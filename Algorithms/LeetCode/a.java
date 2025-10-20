package LeetCode;

class FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for(String s : operations)  {
            if(s.equals("++X") || s.equals("X++")) {
                X++;
            } else {
                X--;
            }
        }
        return X;
    }
}