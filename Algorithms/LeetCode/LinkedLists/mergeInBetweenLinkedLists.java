package LeetCode.LinkedLists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class mergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode dh1 = list1;
        ListNode dh2 = list2;
        while(dh2.next != null) { //to go to the last element of list2
            dh2 = dh2.next;
        }
        for(int i = 0; i < a-1; i++) { //to get to the first element (ath position of lis2)
            dh1 = dh1.next;
        }
        ListNode ddhh = dh1.next;
        for(int i = 0; i < b-a+1; i++) {
            ddhh = ddhh.next;
        }
        dh1.next = null;
        dh1.next = list2;
        dh2.next = ddhh;
        return list1;
    }
}