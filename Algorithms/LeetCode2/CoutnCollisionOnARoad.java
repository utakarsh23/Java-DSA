package LeetCode2;

public class CoutnCollisionOnARoad {
    public static void main(String[] args) {
        System.out.println(countCollisions("RLRSLL"));
    }

    static public int countCollisions(String directions) {
        int n = directions.length();
        int s = 0;
        int e = n;
        for(int i = 0; i < n; i++) {
            if(directions.charAt(i) == 'L') s++;
            else break;
        }
        for(int i = 0; i < n; i++) {
            if(directions.charAt(n-1-i) == 'R') e--;
            else break;
        }
        int ans = e - s;
        for(int i = s; i < e; i++) {
            if(directions.charAt(i) == 'S') ans--;
        }
        return ans;
    }
}
