package LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlipEquivalentBinaryTrees {
        public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if(root1 == null) {
                return true;
            }
            helper1(root1, root2);
            return helper(root1, root2);
        }

        static void helper1(TreeNode node, TreeNode node1) {
            if(node == null) return;
            if(node1.left != null && node.left != null && node.left.val != node1.left.val) {
                TreeNode l = node.left;
                node.left = node.right;
                node.right = l;
            }
            if(node1.left != null && node.left == null) {
                TreeNode l = node.left;
                node.left = node.right;
                node.right = l;
            }
            if(node1.left == null && node.left != null) {
                TreeNode l = node.left;
                node.left = node.right;
                node.right = l;
            }
            helper1(node.left, node1.left);
            helper1(node.right, node1.right);
        }

        static boolean helper(TreeNode node, TreeNode node1) {
            if(node == null && node1 == null) return true;
            if(node == null) return false;
            if(node1 == null) return false;
            if(node.val != node1.val) return false;
            boolean l = helper(node.left, node1.left);
            boolean r = helper(node.right, node1.right);
            return l && r;
        }

    // === Debug Print Utility ===
    public static void printTree(TreeNode root) {
        printTreeHelper(root, "", true);
    }

    private static void printTreeHelper(TreeNode node, String prefix, boolean isTail) {
        if (node == null) return;
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.val);
        if (node.left != null || node.right != null) {
            printTreeHelper(node.left, prefix + (isTail ? "    " : "│   "), false);
            printTreeHelper(node.right, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();
            if (i < arr.length && arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                q.offer(curr.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    // Convert tree to array (level-order with nulls)
    public static List<Integer> treeToArray(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                result.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            } else {
                result.add(null);
            }
        }

        // Remove trailing nulls for clean output
        int last = result.size() - 1;
        while (last >= 0 && result.get(last) == null) {
            result.remove(last--);
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] tree1Arr = {1,2,3,4,5,6,null,null,null,7,8};
        Integer[] tree2Arr = {1,3,2,null,6,4,5,null,null,null,null,8,7};

        TreeNode root1 = buildTree(tree1Arr);
        TreeNode root2 = buildTree(tree2Arr);

//        System.out.println("Tree 1 as array: " + treeToArray(root1));
        System.out.println("Tree 2 as array: " + treeToArray(root2));

        boolean result = flipEquiv(root1, root2);
        System.out.println("Tree 2 as array: " + treeToArray(root2));
        System.out.println("\nAre they flip equivalent? " + result);
    }
}