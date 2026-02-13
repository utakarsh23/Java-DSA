package Trees;

import java.util.Scanner;

public class BinaryTree {

    public BinaryTree() {
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }


    }

    private Node root;

    public void populate(Scanner scanner) {
        System.out.println("Enter the root Node value: ");
        int val = scanner.nextInt();
        root = new Node(val);
        populate(scanner, root);
    }
    public void populate(int[] nums) {
        for (int num : nums) {
            this.insert(num);
        }
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    public Node insert(int val, Node node) {
        if(node == null) {
            node = new Node(val);
            return node;
        }
        if(val < node.value) node.left = insert(val, node.left);
        else if(val > node.value) node.right = insert(val, node.right);

        return node;
    }


    public void populate(Scanner scanner, Node node) {
        System.out.println("Do you wanna enter left of " + node.value);
        boolean left = scanner.nextBoolean();
        if(left) {
            System.out.println("Enter left value of " + node.value);
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner, node.left);
        }
        System.out.println("Do you wanna enter right of " + node.value);
        boolean right = scanner.nextBoolean();
        if(right) {
            System.out.println("Enter right value of " + node.value);
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, "");
    }


    private void display(Node node, String indent) {
        if(node == null) return;
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    private void prettyDisplay() {
        prettyDisplay(root, 0);
    }
    private void prettyDisplay(Node node, int level) {
        if(node == null) return;
        prettyDisplay(node.right, level+1);
        if(level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|---------> " + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level+1);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.populate(input);
        binaryTree.prettyDisplay();
    }
}
