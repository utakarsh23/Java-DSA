package LeetCode2.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeOps {

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < arr.length && !queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.add("null");
            } else {
                res.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        // Trim trailing "null"s (LeetCode omits those)
        int lastNonNull = res.size() - 1;
        while (lastNonNull >= 0 && res.get(lastNonNull).equals("null")) {
            lastNonNull--;
        }

        System.out.print("[");
        for (int i = 0; i <= lastNonNull; i++) {
            System.out.print(res.get(i));
            if (i < lastNonNull) System.out.print(", ");
        }
        System.out.println("]");
    }
}
