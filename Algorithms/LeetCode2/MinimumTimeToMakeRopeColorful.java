package LeetCode2;

public class MinimumTimeToMakeRopeColorful {
    public static void main(String[] args) {
        String colors = "aaabbbabbbb";
        int[] neededTime = new int[] {3,5,10,7,5,3,5,5,4,8,1};
        System.out.println(minCost(colors, neededTime));
    }
    public static int minCost(String s, int[] neededTime) {
        StringBuilder sb = new StringBuilder(s);
        int i = 1;
        int j = 0;
        int k = 1;
        int len = s.length();
        int costSum = 0;
        while(i < len) {
            if(s.charAt(i) == sb.charAt(j)) {
                if(sb.charAt(k) == s.charAt(i)) {
                    if(neededTime[i] > neededTime[i-1]) {
                        sb.deleteCharAt(j);
                        costSum += neededTime[i-1];
                    } else {
                        sb.deleteCharAt(k);
                        costSum += neededTime[i];
                    }
                    i++;
                } else {
                    sb.deleteCharAt(j);
                    costSum += neededTime[i-1];
                    i++;
                }
            } else {
                i++;
                j++;
                k++;
            }
        }
        return costSum;
    }

    public int minCost1(String colors, int[] neededTime) {
        int n = neededTime.length;

        int i = 0;
        int j = 1;
        int ans = 0;

        while(i < n)
        {
            int sum = neededTime[i];
            int max = neededTime[i];

            while(j < n)
            {
                if(colors.charAt(i) != colors.charAt(j)) break;
                sum += neededTime[j];
                max = Math.max(max, neededTime[j]);
                j++;
            }
            ans += sum - max;
            i = j;
            j++;
        }
        return ans;
    }
}
