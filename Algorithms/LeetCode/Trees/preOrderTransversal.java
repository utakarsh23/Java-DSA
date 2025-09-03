package LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

public class preOrderTransversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        helperFunc(root, list);
        return list;
    }
    static void helperFunc(TreeNode node, List<Integer> list) {
        if(node == null) return;
        helperFunc(node.left, list);
        helperFunc(node.right, list);
        list.add(node.val);
    }
}
