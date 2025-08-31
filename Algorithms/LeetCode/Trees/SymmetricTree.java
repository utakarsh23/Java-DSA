package LeetCode.Trees;

public class SymmetricTree {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helperFunc(root.left, root.right);
    }

    static boolean helperFunc(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        boolean l = helperFunc(left.left, right.right);
        boolean r = helperFunc(left.right, right.left);
        return l && r;
    }

    //m2
    //BFS with list and palindrome of the list or maybe a stick with stack valid parenthesis types
}
