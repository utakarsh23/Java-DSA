package LeetCode2;

public class GrayCode {
    public static void main(String[] args) {
        int[] arr = new int[] {0,1,3,2,6,7,5,4};
        for (int x : arr) {
            System.out.print(Integer.toBinaryString(x) + " ");
        }
        System.out.println();
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
}

//000 001 011 010 110 111 101 100

