package Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
////        BST bst = new BST();
//////        bst.populate(new int[] {5, 2, 7, 1, 4, 6, 9, 8, 3, 10});
////        bst.populateSorted(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
////        bst.display();
//        Scanner input = new Scanner(System.in);
//
//        BinaryTree tree = new BinaryTree();
//        tree.populate(input);
//        tree.postOrder();

        AVL tree = new AVL();
        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }

        tree.display();
        System.out.println(tree.height());
    }
}
