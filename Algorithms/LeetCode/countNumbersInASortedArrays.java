package LeetCode;

class countNumbersInASortedArrays {
    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }

    //method 1
    static int countNegatives(int[][] grid) {
        int sum = 0;
        for(int i = 0; i < grid.length; i++) {
            sum += binarySearchForNegativeCount(grid[i]);
        }
        return sum;
    }
    static int binarySearchForNegativeCount(int[] arr) {
        int target = 0;
        int start = 0;
        int end = arr.length-1;
        while(start <= end) {
            int mid = start+(end-start)/2;
            if(target < arr[mid]) {
                start = mid + 1; 
            } else {  
                end = mid -1;
        }
        }
        return arr.length-1-end;
    }

    //method 2
    public int countNegatives1(int[][] grid) {
         int rows = grid.length;
         int cols = grid[0].length;
         int row = 0;
         int col = grid[0].length-1;
         int count = 0;
         while(row < rows && col >= 0){
             if(grid[row][col] >= 0){
                 row++;
             } else {
                 count += rows-row;
                 col--;
             }
         }
         return count;
    }
}