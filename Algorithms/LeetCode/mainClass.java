package LeetCode;

import java.util.ArrayList;
import java.util.List;

import static Randoms.Stackss.list;

class SmallestNoWithAllSetsBit {
    List<Long> list = new ArrayList<>();
    SmallestNoWithAllSetsBit() {
        long i = 1;
        while(i < 1e18) {
            list.add(i);
            System.out.println(i);

            i = (i * 2) + 1;
        }
        list.add(i);
    }

    public long smallestNumber(int n) {
        return binarySearch(n);
    }

    public long binarySearch(int tar) {
        int s = 0;
        int e = list.size()-1;
        //t = 6
        //1 3 5 7 9 11
        /* 
            s = 0, e = 5, m = 2; me = 5;
            s = 3, e = 5, m = 4, me = 9;
            s = 3, e = 4, m = 3, me = 7;
            s = 3, e = 3, m = 3, me = 7; 
            s = 3, e = 3, m = 3, me = 7;

            1 3 5 7 9 11 15
            t = 6,
            s = 0, e = 6, m = 3; me = 7;
            s = 0, e = 3, m = 1, me = 3;
            s = 2, e = 3, m = 2, me = 5;
            s = 3, e = 3, m = 3, me = 7; 

            1 3 5 7 9 11 15
            t = 10,
            s = 0, e = 6, m = 3; me = 7;
            s = 4, e = 6, m = 5, me = 11;
            s = 4, e = 5, m = 4, me = 9;
            s = 5, e = 5, m = 5, me = 11; 
        */
        while(s < e) {
            int m = s + (e - s)/2;
            long me = list.get(m);
            if(me > tar) {
                e = m;
            } else if(me < tar) {
                s = m + 1;
            } else if(me == tar) {
                return me;
            }
        }
        return list.get(s);
    }

}

public class mainClass {
    public static void main(String[] args) {
        SmallestNoWithAllSetsBit setsBit = new SmallestNoWithAllSetsBit();
        long i = setsBit.smallestNumber(800);
        System.out.println(i);
        System.out.println(list);
    }
}