package Trees;

class BST {
    public BST() {
    }

    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public int height(Node node) {
        if(node != null) {
            return node.height;
        }
        return -1;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(this.root, "Root Node : ");
    }

    private void display(Node node, String details) {
        if(node == null) return;
        System.out.println(details + node.value);

        display(node.left, "Left child of " + node.value + ": ");
        display(node.right, "Right child of " + node.value + ": ");
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {

        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value) {
            node.left = insert(node.left, value);
        }
        if(value > node.value) {
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if(node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void populate(int[] nums) {
        for (int num : nums) {
            this.insert(num);
        }
    }

    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = start+(end-start)/2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }

}
