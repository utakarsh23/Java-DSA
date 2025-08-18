package Trees;

public class SegmentTree {

    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree(new int[] {});
    }



    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    public SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length-1);
    }

    /// creating
    private Node constructTree(int[] arr, int start, int end) {

        if(start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);

        int mid = start+(end-start)/2;

        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid+1, end);

        node.data = node.left.data+node.right.data;

        return node;
    }

    ///to display
    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        if (node == null) return;

        StringBuilder sb = new StringBuilder();

        // for left node
        if (node.left != null) {
            sb.append("Interval = [")
                    .append(node.left.startInterval).append(", ")
                    .append(node.left.endInterval).append("] & data : ")
                    .append(node.left.data).append(" -> ");
        } else {
            sb.append("No left child!! -> ");
        }

        // for current node
        sb.append("Interval = [")
                .append(node.startInterval).append(", ")
                .append(node.endInterval).append("] & data : ")
                .append(node.data).append(" -> ");

        // for right node
        if (node.right != null) {
            sb.append("Interval = [")
                    .append(node.right.startInterval).append(", ")
                    .append(node.right.endInterval).append("] & data : ")
                    .append(node.right.data);
        } else {
            sb.append("No right child!!");
        }

        // print this node's summary
        System.out.println(sb);

        // recursive calls
        display(node.left);
        display(node.right);
    }

    /// querying
    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        if(node.startInterval >= qsi && node.endInterval <= qei) {
            //lies completely inside the query.
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) { //not inside the range
            return 0;
        } else { //overlapping(internal and external indexes)
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if(index >= node.startInterval && index <= node.endInterval) {
            if(index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }


}
