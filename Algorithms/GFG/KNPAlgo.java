package GFG;

public class KNPAlgo {
    public static void main(String[] args) {
        String s1 = "utkarsh";
        String s2 = "kar";
        System.out.println(normalSearchingAlgo(s1, s2));
    }
    static int normalSearchingAlgo(String s1, String s2) {
        int i = 0;
        int j = 0;
        int temp = 0;
        while(i < s1.length()) {
            temp++;
            while (j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
            if(j == s2.length()) return i-j;
            i = temp;
            j = 0;
        }
        return -1;
    }
}
