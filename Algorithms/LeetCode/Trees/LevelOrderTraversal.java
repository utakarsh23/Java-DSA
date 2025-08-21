package LeetCode.Trees;

import java.util.*;

// Definition for a binary tree node.

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<Integer> queue = new ArrayDeque<>();

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        // Example test case: root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        LevelOrderTraversal solution = new LevelOrderTraversal();
        List<List<Integer>> result = solution.levelOrder(root);

        System.out.println(result); // Expected: [[3],[9,20],[15,7]]
    }
}