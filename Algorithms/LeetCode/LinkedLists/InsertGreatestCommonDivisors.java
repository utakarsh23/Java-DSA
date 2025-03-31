package LeetCode.LinkedLists;

public class InsertGreatestCommonDivisors {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head; // This line has a syntax error: '=' should be '=='
        ListNode dh1 = head;
        ListNode dh2 = head.next;
        ListNode dh = head;
//        ListNode fdh = head.next;
        while(dh1 != null && dh2 != null) {
            int val1 = dh1.val;
            int val2 = dh2.val;
            int ans = gcd(val1, val2);
            dh1.next = null;
            dh1.next = new ListNode(ans);
            dh1 = dh1.next;
            dh1.next = dh2;
            dh1 = dh1.next;
            dh2 = dh2.next;
        }
        return head;
    }

    public int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }

    //m2
    public ListNode insertGreatestCommonDivisors1(ListNode head) {
        if(head.next == null) return head; // This line has a syntax error: '=' should be '=='
        ListNode dh1 = head;
        ListNode dh2 = head.next;
        ListNode dh = head;
        while(dh1 != null && dh2 != null) {
            int ans = gcd(dh1.val, dh2.val);
            ListNode newNode = new ListNode(ans);
            newNode.next = dh2;
            dh1.next = newNode;
            dh1 = dh2;
            dh2 = dh2.next;
        }
        return head;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        InsertGreatestCommonDivisors solution = new InsertGreatestCommonDivisors();

        // Example linked list: 18 -> 6 -> 12 -> null
        ListNode head = new ListNode(18, new ListNode(6, new ListNode(10, new ListNode(3))));

        System.out.println("Original List:");
        solution.printList(head);

        ListNode result = solution.insertGreatestCommonDivisors1(head);

        System.out.println("Modified List:");
        solution.printList(result);
    }
}