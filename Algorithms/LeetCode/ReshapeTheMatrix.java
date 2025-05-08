package LeetCode;

class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
         int rows = mat.length;
        int cols = mat[0].length;
        
        //if the product of rows & cols of mat matrix and the new matrix are not same then return original matrix
        if((rows * cols) != (r * c)) return mat;
        
        //Creating the new matrix
        int[][] output = new int[r][c];
        int output_rows = 0;
        int output_cols = 0;
        
        
        //Traversing the mat matrix and storing the its values in new matrix output cols wise
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                output[output_rows][output_cols] = mat[i][j];
                output_cols++;
                
                //if the cols value reached then change the row and set the cols value to 0.
                if(output_cols == c)
                {
                    output_cols = 0;
                    output_rows++;
                }
            }
        }
        
        return output;
    }
}