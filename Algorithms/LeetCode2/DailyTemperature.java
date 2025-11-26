package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DailyTemperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{99,99,99,99,99,99,99,99,99,99,100})));
    }

    static public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        List<Integer> size = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        List<Integer> index = new ArrayList<>();


        for(int i = 0; i < n; i++) {
            int sl = temperatures[i];
            int j = i+1;
            while(j < n && temperatures[j] == sl) {
                j++;
            }

            size.add(j - i);
            item.add(sl);
            index.add(i);
        }

        int ni = index.size();
        int li = 0;
        for(int i = 0; i < n; i++) {
            // boolean flagged = false;
            int t = temperatures[i];
            if(i > 0 && t == li) {
                temperatures[i] = temperatures[i-1];
                break;
            }
            temperatures[i] = 0;
            int si = 0;
            for(int j = 0; j < ni; j++) {
                si += size.get(j);
                if(index.get(j) > i && item.get(j) > t) {
                    temperatures[i] = si-i-1;
                    li = temperatures[i];
                    break;
                }
            }
        }
        return temperatures;
    }
    // 73 , 74 , 75 , 71 , 69 , 72 , 76 , 73
    // 73   73   73   71   69   69   69   69
    // 69   69   69   69   69   72   72   73

    // 73 , 74 , 75 , 71 , 69 , 72 , 76 , 73
    // 73 74
    // 74 , 75 , 71 , 69 , 72 , 76 , 73
    // 74 75
    // 75 , 71 , 69 , 72 , 76 , 73
    // 75 71 69 72 76
    // 71 , 69 , 72 , 76 , 73
    // 71 69 72
    // 69 , 72 , 76 , 73
    // 69 72
    // 72 , 76 , 73
    // 72 76
    // 76 , 73
    // 76 73
    // 76 , 73
}
