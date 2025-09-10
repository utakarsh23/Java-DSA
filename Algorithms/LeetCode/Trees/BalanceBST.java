package LeetCode.Trees;

public class BalanceBST {
    public boolean isBalanced(TreeNode node) {
        if(node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);

    }
    static int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1+Math.max(height(root.left), height(root.right));
    }
}
