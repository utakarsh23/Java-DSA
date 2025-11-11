package LeetCode2.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumRootToLeafNode {

    public static void main(String[] args) {

        TreeNode n = TreeOps.buildTree(new Integer[]{4,9,0,5,1,4});
        TreeOps.printTree(n);
        System.out.println(sumNumbers(n));
    }

    //m1 - 4ms and beats 7.40%
    public static long sumNumbers(TreeNode root) {
        List<Long> li = new ArrayList<>();
        helper(root, li, "");
        long ans = 0;
        for (long x : li) {
            ans += x;
        }
        return ans;
    }

    static void helper(TreeNode node, List<Long> list, String s) {
        if(node == null) {
            list.add(Long.parseLong(s));
            return;
        }
        s += node.val;
        if(node.left != null && node.right != null) {
            helper(node.left, list, s);
            helper(node.right, list, s);
        } else if(node.left == null) {
            helper(node.right, list, s);
        } else {
            helper(node.left, list, s);
        }
    }


    //m2 - 0ms & beats 100%
    public int sumNumbers1(TreeNode root) {
        return helper1(root, 0);
    }

    static int helper1(TreeNode node, int ans) {
        if (node == null) {
            return ans;
        }
        ans = ans * 10 + node.val;
        int ls = 0;
        int rs = 0;
        if (node.left != null && node.right != null) {
            ls = helper1(node.left, ans);
            rs = helper1(node.right, ans);
        } else if (node.left == null) {
            rs = helper1(node.right, ans);
        } else {
            ls = helper1(node.left, ans);
        }
        return ls + rs;
    }
}
