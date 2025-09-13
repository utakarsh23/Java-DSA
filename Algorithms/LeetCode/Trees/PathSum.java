package LeetCode.Trees;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum);
    }

    public boolean helper(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        boolean l = helper(root.left, targetSum - root.val);
        boolean r = helper(root.right, targetSum - root.val);
        return l || r;
    }
}
