package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryStreeRightSideView {
    public static void main(String[] args) {

    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        helperFunc(list, queue);
        return list;
    }
    public void helperFunc(List<Integer> list, Queue<TreeNode> queue) {
        if(queue.isEmpty()) {
            return;
        }
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if(i == size-1) {
                list.add(node.val);
            }
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        helperFunc(list, queue);
    }
}
