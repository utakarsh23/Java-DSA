package GFG;

import LeetCode.LinkedLists.ListNode;

public class RotateList {


//TLE on head = [1, 2, 3], k = 2000000000, bnut we use k%no of Elements to pass that
    public ListNode rotateRight(ListNode head, int k) {
        ListNode node = head;
        ListNode pdh = node;
        ListNode dummyHead = head.next;

        ListNode toCount = head;
        int noOfElements = 1;
        while (toCount.next != null) {
                noOfElements++;
                toCount  = toCount.next;
        }

        int s = k%noOfElements;
        for (int i = 0; i < k%noOfElements; i++) {
            while(dummyHead.next != null) {
                pdh = pdh.next;
                dummyHead = dummyHead.next;
            }
            dummyHead.next = node;
            pdh.next = null;
            //
            node = dummyHead;
            pdh = node;
            dummyHead = node.next;
        }
        return node;
    }

    //m2
    public ListNode rotate(ListNode head, int k) {
        if(k == 0 || head == null) return head;
        ListNode countNode = head;
        int count = 1;
        while(countNode.next != null) {
            count++;
            countNode = countNode.next;
        }
        k %= count;
        if(k == 0) return head;
        countNode.next = head;

        countNode = head;
        for(int i = 1; i < k; i++) {
            countNode = countNode.next;
        }

        head = countNode.next;
        countNode.next = null;
        return head;

    }

    // Method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.print("Original List: ");
        printList(head);

        RotateList solution = new RotateList();
        int k = 4; // Change this to test different values of k
        head = solution.rotateRight(head, k);

        System.out.print("Rotated List by " + k + " places: ");
        printList(head);
    }
}