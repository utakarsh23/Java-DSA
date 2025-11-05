package LeetCode2;

import java.util.ArrayList;
import java.util.List;

class MedianFinder {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        double median = medianFinder.findMedian();
        System.out.println(median);
        medianFinder.addNum(2);
        median = medianFinder.findMedian();
        System.out.println(median);
        medianFinder.addNum(5);
        median = medianFinder.findMedian();
        System.out.println(median);
        medianFinder.addNum(-3);
        median = medianFinder.findMedian();
        System.out.println(median);
        medianFinder.addNum(-9);
        median = medianFinder.findMedian();
        System.out.println(median);
        medianFinder.addNum(-7);
        median = medianFinder.findMedian();
        System.out.println(median);
        medianFinder.addNum(4);
        median = medianFinder.findMedian();
        System.out.println(median);

        System.out.println(medianFinder.list);
    }


    List<Integer> list;
    int size = 0;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum1(int num) {
        int len = list.size();
        if(len == 0) {
            list.add(num);
            return;
        }
            int i = 0;
            while (i < len && list.get(i) < num) {
                i++;
            }
            list.add(i, num);
    }

    public void addNum(int num) {
        int len = list.size();
        if (len == 0) {
            list.add(num);
            return;
        }

        int start = 0;
        int end = len - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = list.get(mid);

            if (midVal == num) {
                start = mid + 1;
                break;
            } else if (midVal < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        list.add(start, num);
    }
    
    public double findMedian() {
        int len = list.size();
        if(len % 2 != 0) {
            return (double)list.get(len/2);
        }
        return ((double)list.get(len/2) + (double)list.get(len/2-1))/2;
    }
}
