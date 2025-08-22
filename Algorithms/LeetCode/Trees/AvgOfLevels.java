package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node.

public class AvgOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        queue.offer(root);
        helper(list, queue);
        return list;
    }

    static void helper(List<Double> list, Queue<TreeNode> queue) {
        if(queue.isEmpty()) {
            return;
        }

        double x = 0;
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            TreeNode cn = queue.poll();
            if(cn.left != null) {
                queue.offer(cn.left);
            }
            if(cn.right != null) {
                queue.offer(cn.right);
            }
            x += cn.val;
        }
        list.add(x/size);
        helper(list, queue);
    }


    public static void main(String[] args) {
        // Example test case: root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        AvgOfLevels solution = new AvgOfLevels();
        List<Double> result = solution.averageOfLevels(root);

        System.out.println(result); // Expected: [[3],[9,20],[15,7]]
    }
}