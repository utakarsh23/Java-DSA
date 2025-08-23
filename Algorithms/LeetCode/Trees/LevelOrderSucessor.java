package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node.

public class LevelOrderSucessor {

    public int levelOrder1(TreeNode root, int value) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> list = new ArrayList<>();
//        queue.offer(root);
//        helperFunc(list, queue);
//        return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
                if(node.val == value && !queue.isEmpty()) {
                    return queue.poll().val;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        // Example test case: root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        LevelOrderSucessor solution = new LevelOrderSucessor();
        int result = solution.levelOrder1(root, 98);

        System.out.println(result); // Expected: [[3],[9,20],[15,7]]
    }
}