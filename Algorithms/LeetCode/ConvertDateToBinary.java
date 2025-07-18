package LeetCode;

public class ConvertDateToBinary {
    public static void main(String[] args) {

    }
    static public String convertDateToBinary(String date) {
        String[] arr = date.split("-");
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for(String t : arr) {
            t = binaryConversion(t);
            sb.append(t);
            sb.append("-");
        }
        return sb.substring(0, sb.length());
    }

    static String binaryConversion(String t) {
        StringBuilder sb = new StringBuilder();
        int s = Integer.parseInt(t);
        while(s != 0) {
            int rem = s % 2;
            sb.append(rem);
            s /= 2;
        }
        return sb.reverse().toString();
    }
}
