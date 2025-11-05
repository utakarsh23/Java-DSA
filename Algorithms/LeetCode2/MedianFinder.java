package LeetCode2;

import java.util.ArrayList;
import java.util.List;

class MedianFinder {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        medianFinder.addNum(-3);
        medianFinder.addNum(6);
        medianFinder.addNum(-4);
        medianFinder.addNum(9);
        medianFinder.addNum(-5);
        medianFinder.addNum(4);
        medianFinder.addNum(7);
        double median = medianFinder.findMedian();
        System.out.println(median);
        System.out.println(medianFinder.list);
    }



// Map<Integer, Integer> map = new HashMap<>();
// int[] arr = new int[101];
    List<Integer> list;
    int size = 0;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int len = list.size();
        if(len == 0) {
            list.add(num);
            return;
        }
//            if(list.get(i) < num)
            int i = 0;
            while (i < len && list.get(i) < num) {
                i++;
            }
            list.add(i, num);
        // arr[num]++;
        // size++;
    }
    
    public double findMedian() {
        // int count = 0;
        // int mid1 = (size + 1) / 2;
        // int mid2 = (size % 2 == 0) ? (size / 2 + 1) : mid1;

        // int num1 = -1, num2 = -1;
        // for (int i = 0; i <= 100; i++) {
        //     count += arr[i];
        //     if (num1 == -1 && count >= mid1) num1 = i;
        //     if (num2 == -1 && count >= mid2) {
        //         num2 = i;
        //         break;
        //     }
        // }
        // return (num1 + num2) / 2.0;
        int len = list.size();
        if(len % 2 != 0) {
            return (double)list.get(len/2);
        }
        return ((double)list.get(len/2) + (double)list.get(len/2-1))/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */