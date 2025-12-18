package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCodeII {
    public static void main(String[] args) {
//        int[] arr = new int[] {0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8,24,25,27,26,30,31,29,28,20,21,23,22,18,19,17,16};
//        for (int x : arr) {
//            System.out.print(Integer.toBinaryString(x) + " ");
//        }

        int n = 3;
        List<Integer> list = new ArrayList<>();

        n = (int)Math.pow(2, n);

        for (int i = 0; i < n; i++) {

            list.add(i ^ (i >> 1));

            System.out.print(Integer.toBinaryString(i) + " xor ");
            System.out.print(Integer.toBinaryString(i >> 1) + " => ");
            System.out.print(Integer.toBinaryString(i ^ (i >> 1)) + ", ");

        }
        System.out.println();
        System.out.println(list);
//        System.out.println(new GrayCodeII().grayCode(3));
        int[] ar1 = new int[] {1, 2};
        int[] ar2 = new int[] {3, 4};

    }
//    public List<Integer> grayCode(int n) {
//        String[] sss = new String[(int) Math.pow(2, n)];
//        String[] ss = helper(Arrays.copyOfRange(sss, 0, sss.length/2), Arrays.copyOfRange(sss, sss.length/2, sss.length) , "0", true);
//        return new ArrayList<>();
//    }
//
//    private String[] helper(String[] left, String[] right, String add, boolean isLeft) {
//        if(left.length == 1) {
//            if(isLeft) { left[0] = add; return left; }
//            else {right[0] = add; return right;}
//        }
//        if(!isLeft) {
//            int len = left.length - 1;
//            for(int j = len; j >= 0; j--) {
//                String l = left[j];
//                right[len - j] = add + l.substring(1);
//            }
//        }
//
//
//        String[] lefts = helper(Arrays.copyOfRange(left, 0, left.length/2), Arrays.copyOfRange(left, left.length/2, left.length), "0", true);
//        String[] rights = helper(lefts, Arrays.copyOfRange(left, left.length/2, left.length), "1", false);
//        String[] arr = new String[lefts.length + rights.length];
//        int i = 0;
//        for(i = 0; i < lefts.length; i++) {
//            arr[i] = lefts[i];
//        }
//        int j = 0;
//        for( ; i < arr.length; i++) {
//            arr[i] = rights[j++];
//        }
//
//        return arr;
//
//
//    }


    public List<Integer> grayCode(int n) {
        List<String> bin = build(n);
        List<Integer> res = new ArrayList<>();
        System.out.println(bin);
        for (String s : bin) {
            res.add(Integer.parseInt(s, 2));
        }
        return res;
    }

    private List<String> build(int n) {
        if (n == 0) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        List<String> prev = build(n - 1);
        List<String> cur = new ArrayList<>();

        for (String s : prev) {
            cur.add("0" + s);
        }

        for (int i = prev.size() - 1; i >= 0; i--) {
            cur.add("1" + prev.get(i));
        }

        return cur;
    }

}