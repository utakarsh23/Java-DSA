package GFG;

public class pushZerosToEnd {
    public static void main(String[] args) {
        System.out.println();
    }
    static void pushZerosToEnd(int[] arr) {
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != 0) {
                arr[i++] = arr[j];
            }
        }
        while (i < arr.length) {
            arr[i++] = 0;
        }
    }
}
