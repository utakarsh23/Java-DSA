package Randoms;

import java.util.*;

class Parent {
    String name = "Parent";

    Parent() {
        System.out.println("Parent constructor called");
    }

    void showMessage() {
        System.out.println("Hello from Parent class");
    }
}

class Child extends Parent {
    String name = "Child";

    Child() {
        super();
        System.out.println("Child constructor called");
    }

    void display() {
        System.out.println("Child name = " + name);

        System.out.println("Parent name = " + super.name);

        super.showMessage();
    }
}

public class Main {
    public static void main (String[] args)
    {
        // your code goes here
        Integer[] arr = {5, 2, 9, 1, 3};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
        List<Integer> list = new ArrayList<>();
//        Collections.reverse();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            int ind = s.indexOf('1');
            if(s.indexOf('0') == -1) {
                System.out.println(0);
                continue;
            }
            if(ind == -1) {
                System.out.println(n);
            } else {
                System.out.println(ind);
            }

        }
    }
}