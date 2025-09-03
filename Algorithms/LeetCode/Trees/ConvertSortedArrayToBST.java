package LeetCode.Trees;

import java.util.Arrays;

public class ConvertSortedArrayToBST {

    /// m1
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        TreeNode node = new TreeNode(nums[nums.length/2]);
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length/2));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length/2+1, nums.length));
        return node;
    }

}
