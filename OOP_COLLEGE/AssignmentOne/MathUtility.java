package AssignmentOne;

//29
public class MathUtility {

    public int arrayMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int x : arr) {
            max = Math.max(x, max);
        }
        return max;
    }

    public int arrayMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int x : arr) {
            min = Math.min(x, min);
        }
        return min;
    }

}

class mainClass2 {
    public static void main(String[] args) {
        MathUtility mu = new MathUtility();

        System.out.println(mu.arrayMax(new int[] {1, 2, 5, 3, 5, 3}));
        System.out.println(mu.arrayMin(new int[] {1, 2, 5, 3, 5, 3}));
    }
}
