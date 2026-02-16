package DP_LC;

class MaxNoOfPointsWithCost {
    public static void main(String[] args) {
        System.out.println(new MaxNoOfPointsWithCost().maxPoints(new int[][] {{1,2,3},{1,5,1},{3,1,1}}));
    }


    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        // long ans = Integer.MIN_VALUE;
        // for(int i = 0; i < n; i++) {
        //     ans = Math.max(ans, helper(points, m-1, 0) + points[n-1][i]);
        // }
        return helper(points, m-1, 0);
    }

    private long helper(int[][] points, int m, int index) {
        if(m < 0) return 0;
        int n = points[0].length;
        long ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, helper(points, m-1, i) + points[m][i]);
        }
        return ans;
    }
}