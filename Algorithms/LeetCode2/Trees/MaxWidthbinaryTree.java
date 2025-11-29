package LeetCode2.Trees;

import LeetCode.STL;

import java.util.LinkedList;

class MaxWidthbinaryTree {
//    public int widthOfBinaryTree(TreeNode root) {
//        if (root == null) return 0;
//
//        LinkedList<Object> q = new LinkedList<>();
//        q.offer(new STL.Pair<>(root, 0L));
//        int maxWidth = 0;
//
//        while (!q.isEmpty()) {
//            int size = q.size();
//            long minIndex = q.peek().getValue(); // normalize for overflow safety
//            long first = 0, last = 0;
//
//            for (int i = 0; i < size; i++) {
//                STL.Pair<TreeNode, Long> p = (STL.Pair<TreeNode, Long>) q.poll();
//                TreeNode node = p.getKey();
//                long index = p.getValue() - minIndex;
//
//                if (i == 0) first = index;
//                if (i == size - 1) last = index;
//
//                if (node.left != null)
//                    q.offer(new STL.Pair<>(node.left, 2 * index));
//
//                if (node.right != null)
//                    q.offer(new STL.Pair<>(node.right, 2 * index + 1));
//            }
//            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
//        }
//
//        return maxWidth;
//    }
}