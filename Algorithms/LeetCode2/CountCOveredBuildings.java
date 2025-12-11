package LeetCode2;

import java.util.*;

public class CountCOveredBuildings {
    public static void main(String[] args) {
        System.out.println(new CountCOveredBuildings().countCoveredBuildings(3, new int[][] {{1,3},{2,2},{2,3},{2,5},{3,2},{3,3},{3,5},{5,3}}));
    }

    public int countCoveredBuildings(int n, int[][] buildings) {
//        Map<Integer, List<Integer>> horiz = new HashMap<>(); // right const
//        Map<Integer, List<Integer>> verti = new HashMap<>(); // left const
//        for(int[] x : buildings) {
//            if(!horiz.containsKey(x[1])) {
//                List<Integer> list = new ArrayList<>();
//                list.add(x[0]);
//                horiz.put(x[1], list);
//            } else {
//                List<Integer> integers = horiz.get(x[1]);
//                integers.add(x[0]);
//                horiz.put(x[1], integers);
//            }
//            if(!verti.containsKey(x[0])) {
//                List<Integer> list = new ArrayList<>();
//                list.add(x[1]);
//                verti.put(x[0], list);
//            } else {
//                List<Integer> integers = horiz.get(x[0]);
//                integers.add(x[1]);
//                verti.put(x[0], integers);
//            }
//        }
//        return 5;
        int[] minr=new int[n+1];
        int[] maxr=new int[n+1];
        int[] minc=new int[n+1];
        int[] maxc=new int[n+1];
        Arrays.fill(minr,Integer.MAX_VALUE);
        Arrays.fill(minc,Integer.MAX_VALUE);
        for(int[] p:buildings){
            int x=p[0];
            int y=p[1];
            maxr[y]=Math.max(maxr[y],x);
            minr[y]=Math.min(minr[y],x);
            maxc[x]=Math.max(maxc[x],y);
            minc[x]=Math.min(minc[x],y);
        }
        int ct=0;
        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];
            if (
                    x > minr[y] && x < maxr[y] && y > minc[x] && y < maxc[x]
            ) {
                ct++;
            }
        }
        return ct;
    }
}
