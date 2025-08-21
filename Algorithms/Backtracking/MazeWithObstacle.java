package Backtracking;

public class MazeWithObstacle {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true, true},
                {true, false, true, true},
                {true, true, true, true},
                {true, true, true, true}
        };
        PathsRestrictions("", board, 0, 0);

    }
    static void PathsRestrictions(String p, boolean maze[][], int row, int col) {
        if(row == maze.length-1 && col == maze[0].length-1) {
            System.out.println(p);
            return;
        }
        if(!maze[row][col]) {
            return;
        }
        if(row < maze.length-1) {
            PathsRestrictions(p+"D", maze, row+1, col);
        }
        if(col < maze[0].length-1) {
            PathsRestrictions(p+ "CodeChef/S200", maze, row, col+1);
        }
    }
}
