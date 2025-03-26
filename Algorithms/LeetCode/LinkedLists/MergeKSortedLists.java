package LeetCode.LinkedLists;

/**
 * Definition for singly-linked list.
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode mainList = dummy;
        ListNode dh = dummy;
        for (int i = 0; i < lists.length; i++) {
            ListNode list1 = lists[i];
            ListNode dlists = list1;
            ListNode dlist1 = dlists;
            while (dlist1 != null && dh != null) {
                if(dlist1.val < dh.val) {
                    mainList.next = dlist1;
                    dlist1 = dlist1.next;
                    mainList = mainList.next;
                } else { // dlist1.val > dh.val
                    mainList.next = dh;
                    dh = dh.next;
                    mainList = mainList.next;
                }
            }
            while (dlist1 != null) {
                mainList.next = dlist1;
                mainList = mainList.next;
                dlist1 = dlist1.next;
            }

            while (dh != null) {
                mainList.next = dh;
                mainList = mainList.next;
                dh = dh.next;
            }
        }
        return dummy.next;
    }

    // Helper function to print the linked list
    private String printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" -> ");
            head = head.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        MergeKSortedLists merger = new MergeKSortedLists();

        // Creating test cases
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = {l1, l2, l3};

        // Merging lists and printing result
        ListNode mergedHead = merger.mergeKLists(lists);
        System.out.println("Final Merged List: " + merger.printList(mergedHead));
    }
}