package LeetCode.Trees;

import java.util.*;

public class DiameterOfABinaryTree {


    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
        System.out.println(Math.random());
    }
    //m0
    //most efficient, DFS
    public int diameterOfBinaryTree0(TreeNode root) {
        int[] max = new int[1];
        dfs(root, max);
        return max[0];
    }

    private int dfs(TreeNode node, int[] max) {
        if (node == null) return 0;
        int left = dfs(node.left, max);
        int right = dfs(node.right, max);
        max[0] = Math.max(max[0], left + right);
        return 1 + Math.max(left, right);
    }



    //m1
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[] {0};
        dummyRoot(root, max);
        return max[0];
    }
    static void dummyRoot(TreeNode node, int[] max) {
        if(node == null) {
            return;
        }
        int leftMax = height(node.left);
        int rightMax = height(node.right);
        int tMax = leftMax + rightMax;
        max[0] = Math.max(tMax, max[0]);
        dummyRoot(node.left, max);
        dummyRoot(node.right, max);
    }

    static int height(TreeNode node) {
        if(node == null) return 0;
        return 1+Math.max(height(node.left), height(node.right));
    }



    //m2

    public static int diameterOfBinaryTree1(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        int[] max = new int[] {0};
        dummyRoot1(root, max, map);
        return max[0];
    }
    static void dummyRoot1(TreeNode node, int[] max, Map<TreeNode, Integer> map) {
        if(node == null) {
            return;
        }
        int leftMax;
        if(!map.containsKey(node.left)) leftMax = height(node.left);
        else leftMax = map.get(node.left);

        int rightMax;
        if(!map.containsKey(node.right)) rightMax = height(node.right);
        else rightMax = map.get(node.right);
        int tMax = leftMax + rightMax;
        map.put(node, tMax);
        max[0] = Math.max(tMax, max[0]);
        dummyRoot1(node.left, max, map);
        dummyRoot1(node.right, max, map);
    }
}
