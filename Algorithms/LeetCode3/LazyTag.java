package LeetCode3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
===========================================================
Problem Logic (High Level)
===========================================================

Goal:
Find the longest subarray where:
- For DISTINCT elements in that subarray
- #even elements == #odd elements

Key Idea:
1. Convert number -> +1 (even), -1 (odd).
2. Only FIRST occurrence of each value contributes.
3. Use prefix sum.
4. Longest subarray with sum == 0.

Complication:
When sliding left boundary:
- If we remove the first occurrence of a value,
- The next occurrence becomes "first"
- So its contribution must be added.
- That requires range update of prefix sums.

Segment tree handles:
- Range add
- Find index where prefixSum == 0
Both in O(log n)

Overall complexity: O(n log n)
*/


/*
-----------------------------------------------------------
LazyTag
-----------------------------------------------------------

Represents pending range addition.
We only need one integer: toAdd.
*/
class LazyTag {

    int toAdd;

    LazyTag() {
        this.toAdd = 0;
    }

    // Merge lazy tags
    LazyTag add(LazyTag other) {
        this.toAdd += other.toAdd;
        return this;
    }

    boolean hasTag() {
        return this.toAdd != 0;
    }

    void clear() {
        this.toAdd = 0;
    }
}


/*
-----------------------------------------------------------
SegmentTreeNode
-----------------------------------------------------------

Each node stores:
- minValue in this range
- maxValue in this range
- lazy tag for range updates

Why min & max?
To prune search:
If val not in [min, max] => impossible inside this segment.
*/
class SegmentTreeNode {

    int minValue;
    int maxValue;
    LazyTag lazyTag;

    SegmentTreeNode() {
        this.minValue = 0;
        this.maxValue = 0;
        this.lazyTag = new LazyTag();
    }
}


/*
-----------------------------------------------------------
SegmentTree
-----------------------------------------------------------

Supports:
1) Range add
2) Find rightmost position where value == target

Tree is 1-indexed internally.
*/
class SegmentTree {

    private int n;

    /*
    Why size = 4 * n ?

    A segment tree is a binary tree.
    - Worst case total nodes < 4 * n.
    - This guarantees enough space even when n is not power of 2.

    We are NOT storing array elements directly.
    We are storing TREE NODES.
    Each node represents a RANGE [l, r].
    */
    private SegmentTreeNode[] tree;

    SegmentTree(int[] data) {

        this.n = data.length;

        // allocate safe capacity
        this.tree = new SegmentTreeNode[this.n * 4];
        //we do not include zero
        // t[1] = [0, n] & max, min
        // t[2] = [0, n/2] & max, min
        // t[3] = [n/2+1, n] & max, min
        // t[4] = [0, n/4] & max, min
        // t[5] = [n/4+1, n/2] & max, min
        // .... and so on till (l == r).
        // t[k] = [0] & min, max
        // t[k+1] = [1] & max, min
        // ..
        // t[k+n-1] = [n-1] & min, max

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new SegmentTreeNode();
        }

        /*
        build(data, l, r, index)

        l,r  = range in original array this node represents
        index = position of this node inside tree[]
        */
        build(data, 1, this.n, 1);
    }

    /*
    Each node stores:

    - minValue in its segment
    - maxValue in its segment
    - lazy tag for pending addition

    Why min & max?
    Because when searching for value == target,
    if target < min OR target > max,
    it cannot exist in this segment → prune.
    */

    private void build(int[] data, int l, int r, int index) {

        // Base case: single element
        if (l == r) {

            // data is 0-indexed
            tree[index].minValue = data[l - 1];
            tree[index].maxValue = data[l - 1];
            return;
        }

        /*
        mid = (l + r) / 2

        Instead of:
        l + ((r - l) >> 1)

        That expression is just overflow-safe version
        of (l + r) / 2.
        */

        int mid = l + (r - l) / 2;

        /*
        Left child index = index * 2
        Right child index = index * 2 + 1

        Bit version:
            i << 1       == i * 2
            (i << 1) | 1 == i * 2 + 1
        */

        int leftChild = index * 2;
        int rightChild = index * 2 + 1;

        build(data, l, mid, leftChild);
        build(data, mid + 1, r, rightChild);

        /*
        pushup:
        After children are built,
        compute this node's min and max
        from its children.
        */
        pushup(index);
    }

    /*
    Recompute current node from children.
    */
    private void pushup(int index) {

        int leftChild = index * 2;
        int rightChild = index * 2 + 1;

        tree[index].minValue = Math.min(tree[leftChild].minValue, tree[rightChild].minValue);

        tree[index].maxValue = Math.max(tree[leftChild].maxValue, tree[rightChild].maxValue);

    }

    /*
    Apply lazy addition to a node.
    */
    private void applyTag(int index, LazyTag tag) {

        tree[index].minValue += tag.toAdd;
        tree[index].maxValue += tag.toAdd;

        tree[index].lazyTag.add(tag);
    }

    /*
    Push lazy value to children before going deeper.
    */
    private void pushdown(int index) {

        if (!tree[index].lazyTag.hasTag()) return;

        int leftChild = index * 2;
        int rightChild = index * 2 + 1;

        LazyTag tag = new LazyTag();
        tag.toAdd = tree[index].lazyTag.toAdd;

        applyTag(leftChild, tag);
        applyTag(rightChild, tag);

        tree[index].lazyTag.clear();
    }

    /*
    Public range add.
    */
    void add(int l, int r, int val) {

        LazyTag tag = new LazyTag();
        tag.toAdd = val;

        update(l, r, tag, 1, this.n, 1);
    }

    /*
    Range update.

    targetL, targetR = update range
    l, r             = current node range
    index            = current node
    */
    private void update(int targetL, int targetR, LazyTag tag, int l, int r, int index) {

        // fully covered
        if (targetL <= l && r <= targetR) {
            applyTag(index, tag);
            return;
        }

        pushdown(index);

        int mid = l + (r - l) / 2;

        int leftChild = index * 2;
        int rightChild = index * 2 + 1;

        if (targetL <= mid)
            update(targetL, targetR, tag, l, mid, leftChild);

        if (targetR > mid)
            update(targetL, targetR, tag, mid + 1, r, rightChild);

        pushup(index);
    }

    /*
    Find rightmost index in [targetL, targetR]
    where value == val.
    */
    int findLast(int start, int val) {

        if (start > this.n) return -1;

        return find(start, this.n, val, 1, this.n, 1);
    }

    private int find(int targetL, int targetR, int val, int l, int r, int index) {

        /*
        Pruning:
        If val not inside [min, max],
        impossible here.
        */
        if (tree[index].minValue > val || tree[index].maxValue < val) return -1;

        // leaf
        if (l == r) return l;

        pushdown(index);

        int mid = l + (r - l) / 2;

        int leftChild = index * 2;
        int rightChild = index * 2 + 1;

        /*
        Search RIGHT first
        because we want RIGHTMOST index.
        */

        if (targetR >= mid + 1) {

            int res = find(targetL, targetR, val, mid + 1, r, rightChild);

            if (res != -1) return res;
        }

        if (targetL <= mid) {
            return find(targetL, targetR, val, l, mid, leftChild);
        }

        return -1;
    }
}


/*
-----------------------------------------------------------
Main Logic
-----------------------------------------------------------
*/
class LongestBalancedSubarrayII {

    public int longestBalanced(int[] nums) {

        /*
        Map value -> queue of occurrence positions.
        Needed to know next occurrence when sliding.
        */
        Map<Integer, Queue<Integer>> occurrences = new HashMap<>();

        int n = nums.length;
        int[] prefixSum = new int[n];

        /*
        Step 1:
        Build initial prefix sum considering
        ONLY first occurrence of each value.
        */

        prefixSum[0] = sgn(nums[0]);
        occurrences.computeIfAbsent(nums[0], k -> new LinkedList<>()).add(1);

        for (int i = 1; i < n; i++) {

            prefixSum[i] = prefixSum[i - 1];

            Queue<Integer> occ = occurrences.computeIfAbsent(nums[i], k -> new LinkedList<>());

            // If first time seeing this number
            if (occ.isEmpty()) {
                prefixSum[i] += sgn(nums[i]);
            }

            occ.add(i + 1);
        }

        /*
        Build segment tree over prefixSum.
        */
        SegmentTree seg = new SegmentTree(prefixSum);

        int len = 0;

        /*
        Step 2:
        Slide left boundary i.
        */
        for (int i = 0; i < n; i++) {

            /*
            Try extend window.
            Find largest j >= i+len
            such that prefixSum[j] == 0.

            If found, j - i is balanced.
            */
            int pos = seg.findLast(i + len, 0);
            if (pos != -1)
                len = Math.max(len, pos - i);

            /*
            Now remove nums[i] from window.

            Its next occurrence becomes first.
            So its contribution must be added.
            */

            occurrences.get(nums[i]).poll();

            int nextPos = n + 1;

            if (!occurrences.get(nums[i]).isEmpty()) {
                nextPos = occurrences.get(nums[i]).peek();
            }

            /*
            Cancel old contribution in range
            [i+1, nextPos-1]

            Why?
            Because from i+1 onward,
            that value should no longer count
            until nextPos.
            */
            seg.add(i + 1, nextPos - 1, -sgn(nums[i]));
        }

        return len;
    }

    /*
    Convert:
    even -> +1
    odd  -> -1
    */
    private int sgn(int x) {
        return (x % 2) == 0 ? 1 : -1;
    }
}