package LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreepath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        helper(root, new StringBuilder(), result);
        return result;
    }
    void helper(TreeNode node, StringBuilder path, List<String> result){
        if(node == null) return;
        int len = path.length();
        path.append(node.val);
        if(node.left == null && node.right == null){
            result.add(path.toString());
        }
        else{
            path.append("->");
            helper(node.left, path, result);
            helper(node.right, path, result);
        }
        path.setLength(len);
    }
}