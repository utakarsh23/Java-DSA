package LeetCode.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class heights {

    public int height(TreeNode root) {
        return helperFunc1(root, 0);
    }

    //m3
    public int height1(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height1(root.left), height1(root.right));
    }

    //m1
    private int helperFunc(TreeNode node, int i) {
        if(node == null) {
            return i;
        }
        int t = i + 1;
        int l = helperFunc(node.left, t);
        int r = helperFunc(node.right, t);

        return Math.max(l, r);
    }

    //m2
    private int helperFunc1(TreeNode node, int i) {
        if(node == null) {
            return i;
        }
        int l = helperFunc1(node.left, i + 1);
        int r = helperFunc1(node.right, i + 1);

        return Math.max(l, r);
    }




    public static void main(String[] args) {
        // Example test case: root = [3,9,20,null,null,15,7]
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//
//        root.right = new TreeNode(20,
//                new TreeNode(15,
//                        new TreeNode(9, new TreeNode(42), null),
//                        new TreeNode(19)
//                ),
//                new TreeNode(7,
//                        new TreeNode(90),
//                        new TreeNode(45)
//                )
//        );
        TreeNode root = buildTree(new Integer[] {3,9,20,null,null,15,7,9,19,90, 45, 42, 47, 44, 78, 89, 87, 22, 14, 67});

        heights solution = new heights();
        int result = solution.height(root);

        System.out.println(result); // Expected: [[3],[9,20],[15,7]]
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
}