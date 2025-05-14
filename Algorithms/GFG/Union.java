package GFG;

import java.util.HashSet;
import java.util.Set;

public class Union {
    public static void main(String[] args) {

    }
    public static int findUnion(int a[], int b[]) {
        Set<Integer> set = new HashSet<>();
        for(int x : a) {
            set.add(x);
        }
        for(int x : b) {
            set.add(x);
        }
        return set.size();
    }
}
