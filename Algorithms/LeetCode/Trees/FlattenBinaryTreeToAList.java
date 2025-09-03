package LeetCode.Trees;

import java.util.Stack;

public class FlattenBinaryTreeToAList {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(curr);
        helperFunc(root, stack);
    }

    static void helperFunc(TreeNode node, Stack<TreeNode> stack) {
        if(stack.isEmpty()) {
            return;
        }
        TreeNode curr = stack.pop();
        if(curr.right != null) stack.push(curr.right);
        if(curr.left != null) stack.push(curr.left);

        if (!stack.isEmpty()) {
            curr.right = stack.peek();
        }
        curr.left = null;
        helperFunc(node, stack);
    }
}
