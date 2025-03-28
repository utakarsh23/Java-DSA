package LeetCode.LinkedLists;


public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));


        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode result = obj.addTwoNumbers(l1, l2);

        System.out.print("Sum: ");
        printList(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Implement your logic here
        StringBuilder sb = new StringBuilder();
        while (l1.next != null) {
            int x = l1.val;
            sb.append(x);
            l1 = l1.next;
        }
        sb.append(l1.val);
        StringBuilder sb1 = new StringBuilder();
        while (l2.next != null) {
            int x = l2.val;
            sb1.append(x);
            l2 = l2.next;
        }
        sb1.append(l2.val);
        sb = sb.reverse();
        sb1 = sb1.reverse();
        int x = Integer.parseInt(String.valueOf(sb)) + Integer.parseInt(String.valueOf(sb1));
        sb = new StringBuilder(x+"");
//        sb = sb.reverse();
        x = Integer.parseInt(String.valueOf(sb));
        ListNode node = new ListNode(x%10);
        ListNode dn = node;
        x /=10;
        while (x > 0) {
            int rem = x%10;
            x /= 10;
            dn.next = new ListNode(rem);
            dn = dn.next;
        }
        if(node.next == null) {
            return node;
        }
        return node;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }


    //m2 better one
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int total = 0, carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            int num = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }

        return res.next;
    }
}