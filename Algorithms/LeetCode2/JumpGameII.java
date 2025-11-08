package LeetCode2;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class JumpGameII {
    public static void main(String[] args) throws Exception {
//        System.out.println(jump1(new int[] {1, 4, 5, 1, 3, 4, 1, 5, 1, 1, 3, 2, 7, 9}));
        //4, 4, 9
        //1, 5, 9

        int[] num  = loadArray("test1.txt");
        int[] num1 = loadArray("test2.txt");
        int[] num2 = loadArray("test3.txt");


        long start1 = System.nanoTime();
        int ans1 = jump(num);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        int ans2 = jump1(num);
        long end2 = System.nanoTime();

        long start1_2 = System.nanoTime();
        int ans1_2 = jump(num1);
        long end1_2 = System.nanoTime();

        long start2_2 = System.nanoTime();
        int ans2_2 = jump1(num1);
        long end2_2 = System.nanoTime();


        long start1_3 = System.nanoTime();
        int ans3_3 = jump1(num2);
        long end1_3 = System.nanoTime();

        long start2_3 = System.nanoTime();
        int ans2_3 = jump1(num2);
        long end2_3 = System.nanoTime();

        System.out.println("========== Test 1 ==========");
        System.out.println("jump()  result: " + ans1 + " | time: " + ((end1 - start1) / 1_000_000.0) + " ms");
        System.out.println("jump1() result: " + ans2 + " | time: " + ((end2 - start2) / 1_000_000.0) + " ms");
        System.out.println();

        System.out.println("========== Test 2 ==========");
        System.out.println("jump()  result: " + ans1_2 + " | time: " + ((end1_2 - start1_2) / 1_000_000.0) + " ms");
        System.out.println("jump1() result: " + ans2_2 + " | time: " + ((end2_2 - start2_2) / 1_000_000.0) + " ms");
        System.out.println();

        System.out.println("========== Test 3 ==========");
        System.out.println("jump()  result: " + ans3_3 + " | time: " + ((end1_3 - start1_3) / 1_000_000.0) + " ms");
        System.out.println("jump1() result: " + ans2_3 + " | time: " + ((end2_3 - start2_3) / 1_000_000.0) + " ms");
        System.out.println();

        System.out.println("Summary:");
        System.out.println("Test1 Δ = " + (((end2 - start2) - (end1 - start1)) / 1_000_000.0) + " ms (jump1 - jump)");
        System.out.println("Test2 Δ = " + (((end2_2 - start2_2) - (end1_2 - start1_2)) / 1_000_000.0) + " ms (jump1 - jump)");
        System.out.println("Test3 Δ = " + (((end2_3 - start2_3) - (end1_3 - start1_3)) / 1_000_000.0) + " ms (jump1 - jump)");
    }


    public static int[] loadArray(String filename) throws Exception {
        Path path = Path.of(filename);

        // if not found, try LeetCode2/ prefix (helpful in IDE)
        if (!Files.exists(path)) {
            path = Path.of("LeetCode2", filename);
        }
        if (!Files.exists(path)) {
            path = Path.of("Algorithms", "LeetCode2", filename);
        }

        System.out.println("Reading file from: " + path.toAbsolutePath());

        String content = Files.readString(path);
        String[] parts = content.trim().split("[,\\s]+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr[i] = Integer.parseInt(parts[i]);
        return arr;
    }

    //m1 -> sub optimal
    public static int jump(int[] nums) {
        int len = nums.length-1;
        if(len == 0) return 0;
        if(len == 1) return 1;
        // 2,3,1,1,4
        // start with 2, we have 2 options : 3 or 1, we move to highest
        // moved to 3, we have 3 options 1 1 4 : we move to highest

        //2,3,1,4,1
        // start with 2, we have 2 options : 3 or 1, we move to highest
        // moved to 3, now we jabe 3 choices, 1, 4, 1, we move to highest
        //edge case maybe ? when ce + ind + 1 == >= n; we add count and return


        // 2,3,0,3,4,1,1,1
        // start with 2, we have 2 options : 3 or 0, we move to highest
        // moved to 3, we have 3 options 0 3 4 : we move to highest
        int i = 0;
        int count = 0;
        while(i <= len) {
            if(nums[i] + i >= len) {
                count++;
                break;
            }
            i = maxRange(nums, i, nums[i]);
            count++;
        }
        return count;

    }
    //flawed, we are checking the max element instead of the index which will take us to the farthest.
    // ie. 1, 4, 5, 1, 3, 4, 3, 2, 7, 9
    // here in teh 2nd step, i = 1, nums[i] = 4, we will choose the largest number index(2) which takes us max to 1(i) + 1 + (nums[i])5 = 7th index,
    // but if we choose the the index 5(nums[i] = 4) then we can reach i(5) + 1 + 4(nums[i]) -- the last index.
    // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
//    static int maxRange(int[] arr, int s, int ce) {
//        int max = 0;
//        int len =arr.length;
//        int ind = 0;
//        int le = arr[s+1];
//        for(int i = s + 1; i <= s + ce && i < len; i++) {
//            int t = max;
//            max = Math.max(max, arr[i]);
//            if(max >= t && arr[i] >= le) {
//                ind = i;
//                le = arr[i];
//            };
//
//        }
//        return ind;
//    }

    static int maxRange(int[] arr, int s, int ce) {
        int max = 0;
        int len =arr.length;
        int maxRangeIndex = 0;
        int me = 0;
        for(int i = s + 1; i <= s + ce && i < len; i++) {
            int t = max;
            max = Math.max(i + arr[i], max);
            if(max > t) {
                me = arr[i];
            }
            if(max >= t && arr[i] >= me) {
                me = arr[i];
                maxRangeIndex = i;
            }
        }
        return maxRangeIndex;
    }


    //m2 ->optimal
    public static int jump1(int[] nums) {
        int len = nums.length-1;
        if(len == 0) return 0;
        if(len == 1) return 1;
        int i = 0;
        int count = 0;
        int[] abs = new int[4];
        while(i <= len) {
            if(nums[i] + i >= len) {
                count++;
                break;
            }
            abs[3] = i;
            abs = maxRange1(abs, nums, nums[i]);
            i = abs[0];
            count++;
        }
        return count;
    }


    static int[] maxRange1(int[] data, int[] arr, int ce) {
        // data
        // 0 -> maxRangeIndex
        // 1 -> max
        // 2 -> me
        // 3 -> s + ce -> later s
        //1, 4, 5, 1, 3, 4, 1, 5, 1, 1, 3, 2, 7, 9



        int len =arr.length;
        data[0] = 0;
        data[1] = 0;
        data[2] = 0;
        for(int i = data[3] + 1; i <= data[3] + ce && i < len; i++) {
            int t = data[1];
            data[1] = Math.max(i + arr[i], data[1]);
            if(data[1] > t) {
                data[2] = arr[i];
            }
            if(data[1] >= t && arr[i] >= data[2]) {
                data[2] = arr[i];
                data[0] = i;
            }
        }
        data[3] = data[0];
        return data;
    }
}
