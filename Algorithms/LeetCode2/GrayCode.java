package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
//        int[] arr = new int[] {0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8,24,25,27,26,30,31,29,28,20,21,23,22,18,19,17,16};
//        for (int x : arr) {
//            System.out.print(Integer.toBinaryString(x) + " ");
//        }
        System.out.println(new GrayCode().grayCode(3));
    }

    //          0000, 0001, 0011, 0010, 0110, 0111, 0101, 0100, | 1100, 1101, 1111, 1110, 1010, 1011, 1001, 1000
    //
    //      0000, 0001, 0011, 0010, | 0110, 0111, 0101, 0100
    //          |
    //          |
    //  0000, 0001,| 0011, 0010,
    //      |            |
    //      |            |
    //0000,| 0001     0011, 0010,


//000 001 011 010 110 111 101 100

    public List<Integer> grayCode(int n) {

        int al = (int)Math.pow(2, n);
        String[] ans = new String[al];

        int len = Integer.toBinaryString(n).length();
        StringBuilder picker = new StringBuilder("01");

        for(int i = 0; i < len; i++) {
            boolean rev = false;
            int k = 0;

            for (int j = 0; j < al; j++) {

                int ind = !rev ? k++ : k--; // FIX 2 (moved up)

                if (ans[j] == null) ans[j] = picker.charAt(ind) + "";
                else ans[j] = picker.charAt(ind) + ans[j];

                if (k == picker.length() || k == -1) { // FIX 3
                    rev = !rev;
                    k += rev ? -1 : 1;
                }
            }
            picker = new StringBuilder("0" + picker + "1");
        }
        return helper(ans);
    }

    private List<Integer> helper(String[] ans) {
        List<Integer> list = new ArrayList<>();
        for(String s : ans) {
            list.add(binToInt(s));
        }
        return list;
    }

    private int binToInt(String s) {
        return Integer.parseInt(s, 2);
    }

    // private List<Integer> helper(int n) {

    // }

    //1
    //0, 1
    //0, 1


    //2
    //0,1,3,2
    // 000, 001, 011, 010


    //3
    //0,1,3,2,6,7,5,4
    // 000, 001, 011, 010, 110, 111, 101, 100

    //4
    //0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8
    // 000, 001, 011, 010, 110, 111, 101, 100, 1011, 1100, 1110, 1101, 1010, 1011
    // 0000, 0001, 0011, 0010, 0110, 0111, 0101, 0100, 1100, 1101, 1111, 1110, 1010, 1011, 1001, 1000

    public List<Integer> grayCode1(int n) {
        List<Integer> list = new ArrayList<>();
        n = (int)Math.pow(2, n);
        for (int i = 0; i < n; i++) {
            list.add(i ^ (i >> 1));
        }
        return list;
    }


}