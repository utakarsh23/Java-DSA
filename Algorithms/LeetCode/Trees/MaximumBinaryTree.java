package LeetCode.Trees;

import java.util.Arrays;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helperFunc(nums);
    }
    static TreeNode helperFunc(int[] nums) {
        if(nums.length == 0) return null;
        int max = 0;
        int len = nums.length;
        int index = 0;
        for(int x = 0; x < len; x++) {
            if(nums[x] > max) {
                max = nums[x];
                index = x;
            }
        }
        TreeNode node = new TreeNode(max);

        int[] arrl = Arrays.copyOfRange(nums, 0, index);
        node.left = helperFunc(arrl);
        int[] arrr = Arrays.copyOfRange(nums, index + 1, len);
        node.right = helperFunc(arrr);

        return node;
    }


    public static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        MaximumBinaryTree obj = new MaximumBinaryTree();
        int[] nums = {3, 2, 1, 6, 0, 5};

        TreeNode root = obj.constructMaximumBinaryTree(nums);

        System.out.println("Preorder Traversal of Constructed Maximum Binary Tree:");
        printTree(root);
    }
}
