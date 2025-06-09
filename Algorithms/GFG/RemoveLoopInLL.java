package GFG;

import LeetCode.LinkedLists.ListNode;

import java.util.HashSet;

public class RemoveLoopInLL {
    public static void removeLoop(ListNode head) {
        // code here
        HashSet<ListNode> set = new HashSet<>();
        ListNode prev = null;
        while(head != null) {
            if(!set.contains(head)) {
                set.add(head);
                prev = head;
                head = head.next;
            } else {
                prev.next = null;
                break;
            }
        }
    }
}
