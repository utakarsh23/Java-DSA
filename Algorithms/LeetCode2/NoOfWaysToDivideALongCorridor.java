package LeetCode2;

public class NoOfWaysToDivideALongCorridor {
    public static void main(String[] args) {
        System.out.println(new NoOfWaysToDivideALongCorridor().numberOfWays("SSPPSPS"));
    }

    public int numberOfWays(String corridor) {
        int sCount = charCount(corridor);
        if(sCount % 2 != 0) return 0;
        if(sCount == 2) return 1;
        if(sCount == 0) return 0;
        int ts = 0;
        int n = corridor.length();
        int i = 0;
        long ans = 1;
        long mod = 1_000_000_007;
        while(i < n){
            if(corridor.charAt(i) == 'S') {sCount--; ts++; i++; continue;}
            int beforePlantIndex = i-1;
            if(!check(ts, sCount)) {i++; continue;}
            while(i < n && corridor.charAt(i) == 'P' && check(ts, sCount)) i++;
            ans = (ans * (i - beforePlantIndex))%mod;
        }

        return (int)ans;
    }

    private boolean check(int leftS, int rightS) {
        return leftS%2 == 0 && rightS % 2 == 0 && rightS >= 2 && leftS >= 2;
    }




    private int charCount(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            count += c == 'S' ? 1 : 0;
        }
        return count;
    }
}
