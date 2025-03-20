package LeetCode.LinkedLists;

public class mergeNodesInBetweenZeroes {
    public static void main(String[] args) {
        // Creating a test case: [0,3,1,0,4,5,2,0]
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);
        
        Solution solution = new Solution();
        ListNode result = solution.mergeNodes(head);

        // Printing the result
        printList(result);
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode newNode = new ListNode(0);
        ListNode dummyHead = head;
        ListNode dummyNewNode = newNode;
        while(dummyHead.next != null) {
            dummyHead = dummyHead.next;
            int sum = 0;
            while(dummyHead.next != null && dummyHead.val != 0) {
                sum += dummyHead.val;
                dummyHead = dummyHead.next;
            }
            // dummyHead = dummyHead.next;
            ListNode sumNode = new ListNode(sum);
            dummyNewNode.next = sumNode;
            dummyNewNode = dummyNewNode.next;
        }
        return newNode.next;
    }
}