package LeetCode.Trees;

import java.util.*;

public class FindModeInBST {
    public static void main(String[] args) {
        // Build a sample BST: [1,null,2,2] [6,2,8,0,4,7,9,null,null,2,6]
        TreeNode root = new TreeNode(6);
        root.right = new TreeNode(8);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        FindModeInBST obj = new FindModeInBST();
        int[] result = obj.findMode(root);

        System.out.println("Modes of BST:");
        printArray(result);
    }

    public int[] findMode(TreeNode root){
        Map<Integer, Integer> map = new HashMap<>();
        if(root == null) return new int[] {};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        helperFunc(queue, map);
        List<Integer> list = new ArrayList<>();
        int temp = 0;
        for(int x : map.keySet()) {
            int item = map.get(x);
            if(item > temp) {
                list.clear();
                temp = item;
                list.add(x);
            } else if(item == temp){
                list.add(x);
            }
        }
        int[] arr = new int[list.size()];
        int i = 0;
        for(int x : list) {
            arr[i++] = x;
        }
        return arr;
    }

    static void helperFunc(Queue<TreeNode> queue, Map<Integer, Integer> map) {
        if(queue.isEmpty()) {
            return;
        }
        int len = queue.size();
        for(int i = 0; i < len; i++) {
            TreeNode node = queue.poll();
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        }
        helperFunc(queue, map);
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