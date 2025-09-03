package Randoms;

import java.util.Stack;

public class STX  implements Stackss{

    public void push(int x) {
        list.add(x);
    }

    public int peek() {
        return isEmpty() ? -1 : list.getLast();
    }

    public int pop() {
        return isEmpty() ? -1 : list.removeLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        System.out.println(list);
    }

}


