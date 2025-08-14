package LinkedLists;

public class CustomLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    public void addNum(int num) {

    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if(tail == null) {
            insertFirst(val);
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int  ind) {
        if(ind == 0) {
            insertFirst(val);
            return;
        }
        if(ind == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < ind; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    //insert using recursion
    public void insertRecursion(int val, int index) {
        head = insertRecursion(val, index, head);
    }

    private Node insertRecursion(int val, int index, Node node) {
        if(index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRecursion(val, --index, node.next);
        return node;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast() {
//        int val = tail.value;
//        Node temp = head;
//        for (int i = 1; i < size-1; i++) {
//            temp = temp.next;
//        }
//        tail = temp;
//        tail.next = null;
//        return val;

        if(size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int val = tail.value;

        tail = secondLast;
        tail.next = null;

        size--;
        return val;
    }

    public int delete(int index) {
        if(index == 0) {
            return deleteFirst();
        }
        if(index == size-1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        return val;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if(node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
