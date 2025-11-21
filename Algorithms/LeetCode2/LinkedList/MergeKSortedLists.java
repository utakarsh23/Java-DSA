package LeetCode2.LinkedList;

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        ListNode dummy = lists[0];
        ListNode mergedList = dummy;

        int len = lists.length;
        for (int i = 1; i < len; i++) {
            mergedList = mergeTwoLists(mergedList, lists[i]);  // Merge current list into mergedList
        }
        return mergedList;
    }

    // 1, 4, 5
    // 1, 3, 4
    // 2, 6
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode li = dummy;
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                li.next = list1;
                list1 = list1.next;
//                li = li.next;
            } else  {
                li.next = list2;
                list2 = list2.next;
//                li = li.next;
            }
            li = li.next;
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

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {l1, l2, l3};
        ListNode mergedHead = mergeKLists(lists);

        System.out.println("Merged Linked List:");
        printList(mergedHead);
    }
}