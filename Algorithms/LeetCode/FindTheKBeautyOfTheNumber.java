package LeetCode;

class FindTheKBeautyOfTheNumber {
    public static void main(String[] args) {
        System.out.println(divisorSubstrings(240, 2));
    }
    static int divisorSubstrings(int num, int k) {
        String s = num+"";
        int count = 0;
        for(int i = 0; i < s.length()-k+1; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < i + k; j++) {
                sb.append(s.charAt(j));
            }
            int t = Integer.parseInt(sb.toString());
            if(t != 0 && sb.length() == k && num%t == 0) {
                count++;
            }
        }
        return count;
    }
}