package LeetCode2.Trees;

public class BinaryTreeMaximumPathSum {

    private int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper1(root);
        return max;
    }

    private int helper1(TreeNode node) {
        if(node == null) {return 0;}
        int ls = Math.max(helper1(node.left), 0);
        int rs = Math.max(helper1(node.right), 0);


        int t = node.val + ls + rs;
        max = Math.max(max, t);
        return node.val + Math.max(ls, rs);

    }
}
