package CodeForces;

import java.util.Arrays;
//https://www.codechef.com/problems/CHOCUT


public class ChocoCut {
    public static void main(String[] args) {
        System.out.println(chocCuts(3, 4, 2));
    }
    static int chocCuts(int n, int m, int k) {
        int[] nn = new int[m];
        int[] mm = new int[n];
        Arrays.fill(nn, n);
        Arrays.fill(mm, m);

        int temp = k;
        for (int i = 0; i < nn.length; i++) {
            if(nn[i] <= temp && temp > 0) {
                temp = temp - nn[i];
                nn[i] = 0;
            } else if (temp > 0){
                nn[i] = 0;
                break;
            }
        }

        temp = k;
        for (int i = 0; i < mm.length; i++) {
            if(mm[i] < temp && temp > 0) {
                temp = temp - mm[i];
                mm[i] = 0;
            } else if (temp > 0){
                mm[i] = 0;
                break;
            }
        }
        int n1 = 0;
        for (int i = 0; i < nn.length; i++) {
            if(nn[i] != 0) {
                n1 += nn[i];
            }
        }

        int m1 = 0;
        for (int i = 0; i < mm.length; i++) {
            if(mm[i] != 0) {
                m1 += mm[i];
            }
        }
        return Math.max(m1, n1);
    }
}
