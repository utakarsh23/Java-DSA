package LeetCode.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLevelSums {
    public static void main(String[] args) {

    }
    static int ans = 0;
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        int h = height(root)-1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        helperFunc(queue, h);
        return ans;
    }
    static int height(TreeNode roor) {
        if(roor == null) {
            return 0;
        }
        return 1 + Math.max(height(roor.left), height(roor.right));
    }
    private void helperFunc(Queue<TreeNode> queue, int h) {
        if(queue.isEmpty()) {
            return;
        }
        int levelSize = queue.size();
        int tans = 0;
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();
            tans += node.val;
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        if(h == 0) {
            ans = tans;
        }
        helperFunc(queue, h - 1);
    }
}
