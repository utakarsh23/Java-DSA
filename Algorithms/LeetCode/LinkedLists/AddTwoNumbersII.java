package LeetCode.LinkedLists;

import java.util.Stack;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        ListNode dh1 = l1;
        ListNode dh2 = l2;
        while (dh1.next != null) {
            st1.push(dh1.val);
            dh1 = dh1.next;
        }
        st1.push(dh1.val);
        //
        while (dh2.next != null) {
            st2.push(dh2.val);
            dh2 = dh2.next;
        }
        st2.push(dh2.val);
        //
        int total = 0, carry = 0;

        while (!st1.isEmpty() || !st2.isEmpty() || carry != 0) {
            total = carry;
            if(!st1.isEmpty()) {
                total += st1.pop();
            }
            if(!st2.isEmpty()) {
                total += st2.pop();
            }
            int num = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }
        return res.next;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        AddTwoNumbersII solution = new AddTwoNumbersII();

        // Example input: 342 + 465 (represented as 2 -> 4 -> 3 and 5 -> 6 -> 4)
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = solution.addTwoNumbers(l1, l2);
        solution.printList(result); // Output: 7 -> 0 -> 8 -> null
    }
}