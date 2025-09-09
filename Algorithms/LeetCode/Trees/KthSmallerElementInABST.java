package LeetCode.Trees;

public class KthSmallerElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[] {k};
        return inorder(root, arr);
    }

    private int inorder(TreeNode node, int[] k) {
        if (node == null) return -1;

        int left = inorder(node.left, k);
        if (left != -1) return left;

        k[0]--;
        if (k[0] == 0) return node.val;

        return inorder(node.right, k);
    }
}
