package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigZagGridTraversalWithSkip {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        boolean even = true;
        for(int[] x : grid) {
            list.addAll(helperFunc(x, even));
            even = even ? false : true;
        }
        return list;
    }
    static List<Integer> helperFunc(int[] grid, boolean even) {
        List<Integer> list = new ArrayList<>();
        int len = grid.length;
        int i = 0;
        if(!even) {
            i = 1;
        }
        for(; i < len; i+= 2) {
            list.add(grid[i]);
        }
        if(!even) Collections.reverse(list);
        return list;
    }
}
