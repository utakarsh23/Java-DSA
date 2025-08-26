package LeetCode.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointerInEachNode {

    public static Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);

                if(size == 1 || i == size-1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
            }
        }
        return root;
    }

    public static Node connect1(Node root) {
        if(root == null) return null;

        Node leftMost = root;
        while (leftMost.left != null) {
            Node curr = leftMost;
            while (curr != null) {
                curr.left.next = curr.right;
                if(curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    public static Node connect2(Node root) {
            helperFunc(root.left, root.right);
            return root;
    }
    static void helperFunc(Node left, Node right) {
        if(left == null || right == null) {
            return;
        }
        left.next = right;
        helperFunc(left.left, left.right);
        helperFunc(right.left, right.right);
        helperFunc(left.right, right.left);
    }


    public static void main(String[] args) {
        // Build a perfect binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(8);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.right = new Node(10);
        root.right.right = new Node(7);


        connect2(root);

        printTreeWithNext(root);
    }

    private static void printTreeWithNext(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node curr = levelStart;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                if (curr.next != null) {
                    System.out.print(curr.next.val + "   ");
                } else {
                    System.out.print("null   ");
                }
                curr = curr.next;
            }
            System.out.println();
            levelStart = levelStart.left;
        }
    }
}
