package GFG;

import LeetCode.LinkedLists.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(100, new ListNode(2, new ListNode(8, new ListNode(4, new ListNode(5)))));
        
        ReverseLinkedList obj = new ReverseLinkedList();
        ListNode reversedHead = obj.reverseList3(head); // Implement this method yourself

        printList(reversedHead);
    }

    public ListNode reverseList1(ListNode head) {
        // Implement your logic here
        int count = 1;
        ListNode dummyHead = head;
        while(dummyHead != null && dummyHead.next != null) {
            dummyHead = dummyHead.next;
            count++;
        }
        for (int i = 0; i < count; i++) {
            ListNode temp = head;
            dummyHead.next = temp;
            head = head.next;
            temp.next = null;
            dummyHead = dummyHead.next;
        }
        return dummyHead;
    }


//    public ListNode reverseList(ListNode head) {
//        // Implement your logic here
//        int count = 1;
//        ListNode dummyHead = head;
//        while(dummyHead != null && dummyHead.next != null) {
//            dummyHead = dummyHead.next;
//            count++;
//        }
//        for (int i = 0; i < count; i++) {
//            ListNode temp = head;
//            dummyHead.next = temp;
//            head = head.next;
//            temp.next = null;
//            dummyHead = dummyHead.next;
//        }
//        return head;
//    }

    //using recursion
    public ListNode reverseList(ListNode head) {
        // Implement your logic here
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }



    //my implementation
    public ListNode reverseList2(ListNode head) {
        // Implement your logic here
        if (head == null || head.next == null) return head;
        ListNode previous = null;
        ListNode next = head.next;
        ListNode present = head;
        while (next != null) {
            present.next = previous;
            previous = present;
            present  = next;
            next = next.next;
        }
        present.next = previous;
        return present;
    }

    //KK implementation
    public ListNode reverseList3(ListNode head) {
        // Implement your logic here
        if (head == null || head.next == null) return head;
        ListNode previous = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = previous;
            previous = present;
            present  = next;
            if(next != null) {
                next = next.next;
            }
        }
        return previous;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}