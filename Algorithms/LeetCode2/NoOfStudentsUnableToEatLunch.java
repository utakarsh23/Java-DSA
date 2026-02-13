package LeetCode2;

public class NoOfStudentsUnableToEatLunch {

    public static void main(String[] args) {
        System.out.println(countStudents(new int[] {1,1,0,0}, new int[] {0,1,0,1}));
    }
        public static int countStudents(int[] stu, int[] san) {
            // boolean isDone = false;
            // int n = students.length;
            // List<Integer> st = new ArrayList<>(students);
            // List<Integer> sa = new ArrayList<>(sandwiches);
            // Collections.reverse(st);
            // Collections.reverse(sa);

            // int i = 0;
            // while(!st.isEmpty()) {
            //     if(st.getFirst() == sa.getFirst()) {
            //         st.removeFirst(st);
            //         sa.removeFirst(st);
            //     } else {
            //         int a = st.removeFirst(st);
            //         st.add(a);
            //         i++;
            //     }
            // }

            int n = stu.length;

            boolean[] st = new boolean[n];
            boolean[] sa = new boolean[n];

            int i = 0;
            int j = 0;
            boolean isAllChecked = false;
            while(!isAllChecked) {
                while (i < n && j < n) {
                    i %= n;
                    j %= n;
                    if (st[i]) i++;
                    if (sa[j]) j++;
                    if (stu[i] == san[j]) {
                        st[i] = true;
                        sa[j] = true;
                        i++;
                        j++;
                    } else {
                        i++;
                    }
                }
            }
        return 5;


        }

        // 1 1 1 0 0 1
        // 1 0 0 0 1 1

        // 1 1 0 0 1
        // 0 0 0 1 1

        // 1 0 0 1 1
        // 0 0 0 1 1

        // 0 0 1 1 1
        // 0 0 0 1 1

        // 1 1 1
        // 0 1 1

        //










        // 1 1 0 0
        // 0 1 0 1

        // 1 0 0 1
        // 0 1 0 1

        // 0 0 1 1
        // 0 1 0 1

        // 0 1 1
        // 1 0 1

        // 1 1 0
        // 1 0 1

        // 1 0
        // 0 1

        // 0 1
        // 0 1

        // 1
        // 1

        //
        //
}
