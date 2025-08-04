package LeetCode;

public class FruitsIntoBasketsII {
    public static void main(String[] args) {

    }
    static public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        for(int x : fruits) {
            if(!checkForLeft(baskets, x)) {
                count ++;
            }
        }
        return count;
    }
    static boolean checkForLeft(int[] arr, int x) {
        for(int i = 0;i < arr.length; i++) {
            if(x <= arr[i]) {
                arr[i] = 0;
                x = 0;
                break;
            }
        }
        return x == 0;
    }
}
