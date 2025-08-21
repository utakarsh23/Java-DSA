package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class MazePath {
    public static void main(String[] args) {
        System.out.println(countPaths(51, 9));
    }


    static int countPaths(int row, int col) {
        if(row == 1 || col == 1) {
            return 1;
        }
        int left = countPaths(row-1, col);
        int right = countPaths(row, col-1);

        return left + right;
    }


    static void Paths(String p, int row, int col) {
        if(row == 1 && col == 1) {
            System.out.println(p);
            return;
        }
        if(row > 1) {
            Paths(p+"D", row-1, col);
        }
        if(col > 1) {
            Paths(p+ "CodeChef/S200", row, col-1);
        }
    }


    static List<String> PathNames(String s, int row, int col) {
        if(row == 1 && col == 1) {
            List<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }

        List<String> str = new ArrayList<>();
        if(col > 1) {
            str.addAll(PathNames(s+ "CodeChef/S200", row, col-1));
        }
        if(row > 1) {
            str.addAll(PathNames(s+"D", row-1, col));
        }

        return str;
    }
}
