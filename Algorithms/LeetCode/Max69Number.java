package LeetCode;

public class Max69Number {
    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
    }
    static int maximum69Number (int num) {
        int max = num;
        String temp = Integer.toString(num);
        for(int i = 0; i < temp.length(); i++) {
            if(temp.charAt(i) == '9') {
                int t = swap(temp, i, '6');
                max = Math.max(max, t);
            } else {
                int t = swap(temp, i, '9');
                max = Math.max(max, t);
            }
        }
        return max;
    }

    static int swap(String num, int i, char c) {
        StringBuilder t = new StringBuilder(num);
        t.setCharAt(i, c);
        return Integer.parseInt(t.toString());
    }
}
