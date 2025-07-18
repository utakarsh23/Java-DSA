package LeetCode;

public class FindTheChildWhoHasTheBallAfterKSeconds {
    public static void main(String[] args) {
        System.out.println(numberOfChild(4, 5));
    }
    static public int numberOfChild(int n, int time) {
        int bp1 = 1;
        boolean fwd = true;
        while (time != 0) {
            if (fwd) {
                bp1++;
                if (bp1 == n) {
                    fwd = false;
                }
            } else {
                bp1--;
                if (bp1 == 1) {
                    fwd = true;
                }
            }
            time--;
        }
        return bp1-1;
    }
}
