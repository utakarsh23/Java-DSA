package LeetCode.LinkedLists;

import java.util.*;

class swapNodesInPair {

    //better solution
    public ListNode swapPairs1(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }ListNode temp=head.next;
        head.next=swapPairs(temp.next);
        temp.next=head;
        return temp;
    }


    //brute force as hell
    public ListNode swapPairs(ListNode head) {
        List<ListNode> li = convToList(head);
        swap(li);
        ListNode newNode = new ListNode(0);
        ListNode dh = newNode;
        for (int i = 0; i < li.size(); i++) {
            li.get(i).next = null;
            dh.next = li.get(i);
            dh = dh.next;
        }
        return newNode.next; // To avoid compilation error, return the head
    }

    static List<ListNode> convToList(ListNode head) {
        List<ListNode> li = new ArrayList<>();
        ListNode dh = head;
        while(dh != null) {
            li.add(dh);
            dh = dh.next;
        }
        return li;
    }

    static void swap(List<ListNode> li) {
        ListNode[] ap = new ListNode[li.size()];
        for(int i = 0; i < li.size(); i++){
            ap[i] = li.get(i);
        }
        int j = 1;
        for (int i = 0; i < ap.length-1; i+=2) {
            if(i >= ap.length || j >= ap.length) break;
            ListNode temp = ap[i];
            ap[i] = ap[j];
            ap[j] = temp;
            j+=2;
        }
        for (int i = 0; i < li.size(); i++) {
            li.set(i, ap[i]);
        }
    }
}

public class SwapPairsTest {
    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        
        swapNodesInPair sol = new swapNodesInPair();
        ListNode newHead = sol.swapPairs(head);

        // Printing the swapped linked list
        printList(newHead);
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}