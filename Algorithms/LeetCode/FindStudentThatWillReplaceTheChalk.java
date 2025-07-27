package LeetCode;

public class FindStudentThatWillReplaceTheChalk {
    public static void main(String[] args) {
        System.out.println(chalkReplacer(new int[] {1, 1, 1}, 2));
    }
    static public int chalkReplacer(int[] chalk, int k) {
        int i = 0;
        int len = chalk.length;
        int sum = 0;
        for(int x : chalk) {
            sum += x;
        }
        k = k % sum;
        while(chalk[i] <= k && k != 0) {
            k -= chalk[i];
            i++;
            i = i % len;
        }
        return i;
    }
}
