package LeetCode.Trees;

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
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

    }
    public List<String> helperFunc(TreeNode node, StringBuilder s) {
        if(node == null){
            return "";
        }
        s.append(node.val);
        if(node.left == null && node.right == null){
            return "";
        }
        s.append("->");


    }
}