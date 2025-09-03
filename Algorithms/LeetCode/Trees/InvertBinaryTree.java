package LeetCode.Trees;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        helperFunc(root);
        return root;
    }
    static void helperFunc(TreeNode node) {
        if(node == null) return;
        TreeNode ln = node.left;
        node.left = node.right;
        node.right = ln;
        helperFunc(node.left);
        helperFunc(node.right);
    }
}
