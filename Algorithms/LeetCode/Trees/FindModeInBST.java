package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindModeInBST {
    public static void main(String[] args) {
        // Build a sample BST: [1,null,2,2]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        FindModeInBST obj = new FindModeInBST();
        int[] result = obj.findMode(root);

        System.out.println("Modes of BST:");
        printArray(result);
    }

    public int[] findMode(TreeNode root){
        // Map<Integer, Integer> map = new HashMap<>();
        if(root == null) return new int[] {};
        List<int[]> mainlist = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
//        int[] arr = new int[] {root.val, 1};
//        mainlist.add(arr);
        queue.offer(root);
        helperFunc(queue, mainlist);
        return mainlist.getFirst();
    }

    static void helperFunc(Queue<TreeNode> queue, List<int[]> list) {
        if(queue.isEmpty()) {
            return;
        }
        int len = queue.size();
        int[] arr = new int[2];
        for(int i = 0; i < len; i++) {
            TreeNode node = queue.poll();
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            if(!list.isEmpty() && list.getFirst()[0] < node.val) {
                while(!list.isEmpty()) {
                    list.removeFirst();
                }
                arr[0] = node.val;
                arr[1] = 1;
                list.addFirst(arr);
            } else if(!list.isEmpty() && list.getFirst()[0] == node.val) {
                list.getFirst()[1]++;
            } else {
                arr[0] = node.val;
                arr[1] = 1;
                list.addFirst(arr);
            }
        }
        helperFunc(queue, list);
    }

    static void printArray(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if(i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}