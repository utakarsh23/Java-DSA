package LeetCode.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointerInEachNodeII {


    //m1
    public Node connect1(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node prev = new Node();
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





    //m2
    public Node connect(Node root) {
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
}
