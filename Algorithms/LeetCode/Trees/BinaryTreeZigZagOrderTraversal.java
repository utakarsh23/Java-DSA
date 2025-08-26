package LeetCode.Trees;

import java.util.*;

public class BinaryTreeZigZagOrderTraversal {
    public static void main(String[] args) {
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        helperFunc(queue, list, false);
        return list;
    }
    static void helperFunc(Queue<TreeNode> queue, List<List<Integer>> list, boolean reverse) {
        if(queue.isEmpty()) {
            return;
        }
        int size = queue.size();
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            li.add(node.val);
        }
        reverse = reverse ? false : true;
        if(!reverse) {
            Collections.reverse(li);
        }
        list.add(li);
        helperFunc(queue, list, reverse);
    }
}
