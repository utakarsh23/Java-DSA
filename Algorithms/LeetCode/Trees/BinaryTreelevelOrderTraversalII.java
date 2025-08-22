package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreelevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        helperFunc(list, queue);
        return list;
    }

    static void helperFunc(List<List<Integer>> list, Queue<TreeNode> queue) {
        if(queue.isEmpty()) {
            return;
        }
        int level = queue.size();
        List<Integer> levelList = new ArrayList<>();
        for(int i = 0; i < level; i++) {
            TreeNode node = queue.poll();
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            levelList.add(node.val);
        }
        helperFunc(list, queue);
        list.add(levelList);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        BinaryTreelevelOrderTraversalII solution = new BinaryTreelevelOrderTraversalII();
        List<List<Integer>> result = solution.levelOrderBottom(root);

        System.out.println(result);
    }
}
