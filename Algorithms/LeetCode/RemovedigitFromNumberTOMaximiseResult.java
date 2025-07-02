package LeetCode;

class RemovedigitFromNumberTOMaximiseResult {
    public static void main(String[] args) {
        System.out.println(removeDigit("1231", '1'));
    }
    public static String removeDigit(String number, char digit) {
        String max = "";
        int i = 0;
        while(i < number.length()) {
            if(number.charAt(i) == digit && i < number.length()-1) {
                String t = number.substring(0, i);
                String s = number.substring(i+1);
                if(max.compareTo(t+s) < 1) {
                    max = t+s;
                }
            }
            else if(number.charAt(i) == digit && i == number.length()-1) {
                String t = number.substring(0, i);
                if(max.compareTo(t) < 1) {
                    max = t;
                }
            }
            i++;
        }
        return max;
    }
}