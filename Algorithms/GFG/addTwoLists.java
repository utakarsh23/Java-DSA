package GFG;

import LeetCode.LinkedLists.ListNode;

import java.util.Stack;

public class addTwoLists {
    static ListNode addTwoLists(ListNode num1, ListNode num2) {
        // code here
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(num1 != null) {
            stack1.push(num1.val);
            num1 = num1.next;
        }
        while(num2 != null) {
            stack2.push(num2.val);
            num2 = num2.next;
        }

        int carry = 0;
        ListNode result = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();

            int total = a + b + carry;
            carry = total/10;
            int digit = total%10;

            ListNode newNode = new ListNode(digit);
            newNode.next = result;
            result = newNode;
        }
        while(result != null && result.val == 0 && result.next != null) {
            result = result.next;
        }
        return result;
    }
}
