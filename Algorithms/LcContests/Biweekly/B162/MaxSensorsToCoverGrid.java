package LcContests.Biweekly.B161.B162;

public class MaxSensorsToCoverGrid {
    public static void main(String[] args) {

    }
    public int minSensors(int n, int m, int k) {
        int c = 2 * k + 1;
        int row = (n + c - 1)/c;
        int col = (m + c - 1)/c;
        return row * col;
    }
}
