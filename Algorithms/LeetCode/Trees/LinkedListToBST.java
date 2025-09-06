package LeetCode.Trees;

import LeetCode.LinkedLists.ListNode;

public class LinkedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        return helperFunc(head, null);
    }

    static TreeNode helperFunc(ListNode start, ListNode end) {
        if(start == end) return null;
        ListNode fast = start;
        ListNode slow = start;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = helperFunc(start, slow);
        node.right = helperFunc(slow.next, end);
        return node;
    }
}
