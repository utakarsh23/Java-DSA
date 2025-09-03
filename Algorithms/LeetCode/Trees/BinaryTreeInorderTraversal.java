package LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        helperFunc(root, list);
        return list;
    }
    static void helperFunc(TreeNode node, List<Integer> list) {
        if(node == null) return;
        helperFunc(node.left, list);
        // if(node.left != null) list.add(node.left.val);
        list.add(node.val);
        helperFunc(node.right, list);
        // if(node.right != null) list.add(node.right.val);

    }
}
