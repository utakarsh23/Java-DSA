package LeetCode2.Trees;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDiffInBST {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int n = list.size();
        int i = 1;
        int ans = Integer.MAX_VALUE;
        while(i < n) {
            ans = Math.min(ans, list.get(i) - list.get(i-1));
            i++;
        }

        return ans;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if(node == null) return;

        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }
}
