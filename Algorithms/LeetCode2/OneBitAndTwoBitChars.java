package LeetCode2;

public class OneBitAndTwoBitChars {
    public static void main(String[] args) {

    }
    public boolean isOneBitCharacter(int[] bits) {
        int i=0,n=bits.length;
        while(i<n-1){
            if(bits[i]==0)i++;
            else i+=2;
        }
        return i != n;
    }
}
