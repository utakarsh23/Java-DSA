package LeetCode.Trees;

import LeetCode.Trees.TreeNode;

public class LowestCommonAncestorOfABST {
    public static void main(String[] args) {
        // Build tree [3,5,1,6,2,0,8,null,null,7,4,99]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.left.left.left = null;
        root.left.left.right = null;

        root.left.right.right.right = new TreeNode(99);

        TreeNode p = root.left; // node with val = 5
        TreeNode q = root.left.right.right.right; // node with val = 99

         LowestCommonAncestorOfABST obj = new LowestCommonAncestorOfABST();
        TreeNode lca = obj.lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + ": "
                + (lca != null ? lca.val : "null"));

        System.out.println("\nTree structure:");
        printTree(root, 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }


    static void printTree(TreeNode root, int level) {
        if (root == null) return;
        printTree(root.right, level + 1);
        System.out.println("   ".repeat(level) + root.val);
        printTree(root.left, level + 1);
    }
}