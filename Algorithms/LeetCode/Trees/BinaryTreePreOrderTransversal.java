package LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderTransversal {
    public static void main(String[] args) {
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        helperFunc(list, root);
        return list;
    }

    static void helperFunc(List<Integer> list, TreeNode node) {
        if(node == null) {
            return;
        }
        list.add(node.val);
        helperFunc(list, node.left);
        helperFunc(list, node.right);
    }
}
