import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class nonsttaicsExample {

    int sum(int a, int b) {
        return a + b;
    }
}

class sttaicsExample1 {
    static int sum(int a, int b) {
        return a + b;
    }
}

class mainMethod {
    public static void main(String[] args) {
        nonsttaicsExample ans = new nonsttaicsExample();
        System.out.println(ans.sum(4, 5));

        int sum = sttaicsExample1.sum(4, 5);
        System.out.println(sum);

    }
}
