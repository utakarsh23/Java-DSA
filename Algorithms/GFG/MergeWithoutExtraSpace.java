package GFG;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        int[] a = {2, 4, 7, 10}; int[] b = {2, 3};
        mergeArrays1(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
    static int[] mergeArrays(int[] a, int[] b) {
        int i = a.length-1; int j = b.length-1;
        int k = a.length + b.length - 1;
        int[] ss = new int[a.length + b.length];
        while (i >= 0 && j >= 0) {
            if(a[i] > b[j]) {
                ss[k] = a[i--];
            } else {
                ss[k] = b[j--];
            }
            k--;
        }
        while (i >= 0) {
            ss[k--] = a[i--];
        }
        while (j >= 0) {
            ss[k--] = b[j--];
        }
        return ss;
    }

    static void mergeArrays1(int[] a, int[] b) {
        //merge without extra space
        int i = a.length-1; int j = 0;
        while (i >= 0 && j < b.length) {
            if(a[i] > b[j]) {
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--; j++;
            } else {
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
