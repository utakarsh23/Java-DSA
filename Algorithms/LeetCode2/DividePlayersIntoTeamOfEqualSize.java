package LeetCode2;

import java.util.Arrays;

public class DividePlayersIntoTeamOfEqualSize {
    public long dividePlayers(int[] skill) {
        long ans = 0;
        Arrays.sort(skill);
        int n = skill.length;
        int t = skill[0] + skill[n-1];
        ans += skill[0] * skill[n-1];
        for(int i = 1; i < n/2; i++) {
            int currTeamSum = skill[i] + skill[n-i-1];
            if(currTeamSum != t) return -1;
            ans += skill[i] * skill[n-i-1];
        }
        return ans;
    }
}
