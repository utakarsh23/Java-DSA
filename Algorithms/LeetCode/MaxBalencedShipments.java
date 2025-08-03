package LeetCode;

public class MaxBalencedShipments {
    public static void main(String[] args) {
        System.out.println(maxBalancedShipments(new int[] {2,5,1,4,3}));
    }
    static public int maxBalancedShipments(int[] weight) {
        int max = 0;
        int c = 0;
        for(int x : weight) {
            max = Math.max(x, max);
            if(x < max) {
                c++;
                max = 0;
            }
        }
        return c;
    }
}
