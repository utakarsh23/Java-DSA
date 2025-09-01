package LeetCode.Trees;

public class IncreasingOrdersearchTree {

    public static TreeNode increasingBST(TreeNode root) {
        TreeNode node = new TreeNode(0);
        helperFunc(node, root);
        return node.right;
    }

    static TreeNode helperFunc(TreeNode node, TreeNode tree) {
        if(tree == null) {
            return node;
        }
        node = helperFunc(node, tree.left);
        node.right = new TreeNode(tree.val);
        return helperFunc(node.right, tree.right);
    }

    public static void printRightSkewed(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val);
            if (current.right != null) System.out.print(" -> ");
            current = current.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: Build the tree [5,3,6,2,4,null,8,1,null,null,null,7,9]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.left.left.left = new TreeNode(1);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);


        TreeNode newRoot = increasingBST(root);
        printRightSkewed(newRoot);
    }
}
