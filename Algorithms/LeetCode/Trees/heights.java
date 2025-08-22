package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node.

public class heights {

    public int height(TreeNode root) {
        return helperFunc(root, 0);
    }


    private int helperFunc(TreeNode node, int i) {
        if(node == null) {
            return i;
        }
        int t = i +1;
        int l = helperFunc(node.left, t);
        int r = helperFunc(node.right, t);

        int max = Math.max(l, r);
        return max;
    }


    public static void main(String[] args) {
        // Example test case: root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(9), new TreeNode(7));

        heights solution = new heights();
        int result = solution.height(root);

        System.out.println(result); // Expected: [[3],[9,20],[15,7]]
    }
}