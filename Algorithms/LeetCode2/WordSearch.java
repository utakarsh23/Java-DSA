package LeetCode2;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
//        char[][] board = {{'a','a'}};
//        char[][] board = {{'c','a','a'}, {'a','a','a'},{'b','c','d'}};
//        System.out.println(exist1(board, "ABCEFSADEESE"));
        System.out.println(exist(board, "ABCEFSADEESE"));
    }

    //method 1, brute force
    static public boolean exist1(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Set<String> set = new HashSet<>();
                if(helper(board, board[i][j]+"", i, j, word, set, n, m)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(char[][] board, String pw, int i, int j, String word, Set<String> set, int n, int m) {
        String abs = i+","+j;

        if(pw.equals(word)) return true;
        if(set.contains(abs)) return false;


        if(!contains(pw, word) || word.length() < pw.length()) {
            return false;
        };
        set.add(abs);



        boolean a = false, b = false, c = false, d = false;
        boolean checkI = i >= 0 && i < n;
        boolean checkJ = j >= 0 && j < m;
        if(!set.contains(i+","+j+1) && checkI && j >= 0 && j < m-1) a = helper(board, pw + board[i][j+1], i, j+1, word, set, n, m);
        if(!set.contains(i+1+","+j) && checkJ && i < n-1) b = helper(board, pw + board[i+1][j], i+1, j, word, set, n, m);
        if(!set.contains((i-1)+","+j) && checkJ && i >= 1 && i < n) c = helper(board, pw + board[i-1][j], i-1, j, word, set, n, m);
        if(!set.contains(i+","+(j-1)) && checkI && j >= 1 && j < m) d = helper(board, pw + board[i][j-1], i, j-1, word, set, n, m);
        set.remove(abs);
        return a || b || c || d;
    }

    private static boolean contains(String a, String b) {
        int i = 0;
        int j = 0;
        while(i < a.length() && j < b.length()) {
            if(a.charAt(i) != b.charAt(j)) return false;
            i++; j++;
        }
        return i == a.length();
    }



    //method 2,

    static public boolean exist(char[][] board, String word) {
//        int n = board.length;
//        int m = board[0].length;
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                Set<String> set = new HashSet<>();
//                if(helper1(board, board[i][j]+"", i, j, word, set, n, m)) {
//                    return true;
//                }
//            }
//        }
        return false;
    }

//    static boolean helper1()
}
