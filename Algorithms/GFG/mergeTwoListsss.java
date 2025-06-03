package GFG;

import LeetCode.LinkedLists.ListNode;

class mergeTwoListsss {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode li = dummy;
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                li.next = list1;
                list1 = list1.next;
                li = li.next;
            } else if (list1.val > list2.val) {
                li.next = list2;
                list2 = list2.next;
                li = li.next;
            } else {
                li.next = list1;
                list1 = list1.next;
                li = li.next;
                li.next = list2;
                list2 = list2.next;
                li = li.next;
            }
//            li = li.next;
        }
        while (list1 != null) {
            li.next = list1;
            list1 = list1.next;
            li = li.next;
        }
        while (list2 != null) {
            li.next = list2;
            list2 = list2.next;
            li = li.next;
        }
        return dummy.next;
    }

    // Utility method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(5))));
        ListNode list2 = new ListNode(2, new ListNode(3, new ListNode(4)));

        mergeTwoListsss solution = new mergeTwoListsss();
        ListNode mergedHead = solution.mergeTwoLists(list1, list2);

        System.out.println("Merged List:");
        printList(mergedHead);
    }
}