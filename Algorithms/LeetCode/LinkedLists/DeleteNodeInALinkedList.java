package LeetCode.LinkedLists;

public class DeleteNodeInALinkedList {
    public static void main(String[] args) {

    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
