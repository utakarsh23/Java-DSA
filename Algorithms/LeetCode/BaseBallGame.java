package LeetCode;

import java.util.Stack;

class BaseBallGame {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String s:operations){
            if(s.equals("D")){
                int n = st.peek();
                st.push(2*n);
            }
            else if(s.equals("C")){
                st.pop();
            }
            else if(s.equals("+")){
                int n1 = st.pop();
                int sum = n1+st.peek();
                st.push(n1);
                st.push(sum);
            }
            else{
                st.push(Integer.parseInt(s,10));
            }
        }
        int res=0;
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
    }
}