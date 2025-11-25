package LeetCode2;

import java.util.HashMap;
import java.util.Map;

public class FindMacimumXORSubArrayLength {
    public static void main(String[] args) {
        System.out.print(maxBalancedSubarray(new int[] {2,1,3,2,0}));
    }

    //m1
     static public int maxBalancedSubarray(int[] nums) {
        int i = 0;
        int n = nums.length;
        int ml = 0;
        while(i < n) {
            int oc = nums[i] % 2 != 0 ? 1 : 0;
            int ec = nums[i] % 2 == 0 ? 1 : 0;
            if(ml > n-i) break;

            int xor = nums[i];
            int j = i+1;
            while(j < n) {
                xor ^= nums[j];
                if((nums[j] & 1) != 1) ec++;
                else oc++;
                if(oc == ec && xor == 0) {
                    ml = Math.max(j-i+1, ml);
                }
                j++;
            }
            i++;
        }
        return ml;
    }

    //m2
    public int maxBalancedSubarray1(int[] nums) {
        Map<String, Integer> map=new HashMap<>();
        int isxor=0;
        int eveodd=0;
        int max=0;
        map.put("0!0",-1);
        for(int i=0;i<nums.length;i++){
            isxor^=nums[i];
            if((nums[i]&1)==1){
                eveodd++;
            }
            else{
                eveodd--;
            }
            String curr=isxor+"!"+eveodd;
            if(map.containsKey(curr)){
                max=Math.max(max,i-map.get(curr));
            }
            else{
                map.put(curr,i);
            }

        }
        return max;
    }

}
