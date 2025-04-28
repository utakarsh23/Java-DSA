package GFG;

public class kthElementInTwoDays {
    public static void main(String[] args) {
        System.out.println(kthElement(new int[] {2, 3, 6, 8}, new int[] {1, 4}, 5));
    }
    static int kthElement(int a[], int b[], int k) {
        // code here
        int i = 0;
        int j = 0;
        int t = 0;
        while(i <a.length && j <b.length) {
            if(k == 0) {
                break;
            }
            k--;
            if(a[i] < b[j]) {
                if(k == 0) {
                    t = a[i];
                }
                i++;
            } else {
                if(k == 0) {
                    t = b[j];
                }
                j++;
            }
        }
        while (i < a.length) {
            k--;
            if(k == 0) {
            t = a[i];
            break;
            } else {
                i++;
            }
        }
        while (j < b.length) {
            if(k == 0) {
                t = b[j];
                break;
            } else {
                j++;
                k--;
            }
        }
        return t;
    }
}
