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




    ////////////
    public void flatten1(TreeNode root) {
        if(root == null) return;
        helperFunc1(root);
    }
    static void helperFunc1(TreeNode node) {
        if(node == null) return;
        helperFunc1(node.left);
        helperFunc1(node.right);

        TreeNode left = node.left;
        TreeNode right = node.right;

        node.left = null;
        node.right = left;

        TreeNode curr = node;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = right;
    }

    //m3 iterative
    public void flatten2(TreeNode root) {
        if(root == null) return;

        TreeNode curr = root; //dummy pointer
        while (curr != null) {  //so that could go to all the nodes even in the right
            if(curr.left != null) { //to the left to go for max left node
                TreeNode temp = curr.left; //temp for the same
                while (temp.right != null) { //to the max right so could swap the current's node to the temp one at the end
                    temp = temp.right;
                }
                temp.right = curr.right; //swapping
                curr.right = curr.left; //aaaaaaaaa
                curr.left = null; //null is imp,
            }
            curr = curr.right; //to the next node ans folow the same
        }
    }
}
