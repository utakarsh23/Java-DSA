package LeetCode.Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        // Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        return helperFunc(queue, x, y);
    }

    static boolean helperFunc(Queue<TreeNode> queue, int x, int y) {
        if(queue.isEmpty()) return false;

        int size = queue.size();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if(node.left != null) {
                queue.offer(node.left);
                map.put(node.left.val, node.val);
            }
            if(node.right != null) {
                queue.offer(node.right);
                map.put(node.right.val, node.val);
            }
        }
        if(map.containsKey(x) && map.containsKey(y) && map.get(x) != map.get(y)) {
            return true;
        }
        return helperFunc(queue, x, y);
    }
}
