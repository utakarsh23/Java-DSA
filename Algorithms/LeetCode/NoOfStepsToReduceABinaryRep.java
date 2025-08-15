package LeetCode;

class NoOfStepsToReduceABinaryRep {
    public int numSteps(String s) {
        return numStepsHelper(new StringBuilder(s), 0);
    }
    static int numStepsHelper(StringBuilder s, int i) {
        if(s.toString().equals("1")) {
            return i;
        }
        if(s.charAt(s.length()-1) == '0') {
            s.deleteCharAt(s.length()-1);
        } else {
            addBinary(s);
        }
        return numStepsHelper(s, ++i);
    }
    static void addBinary(StringBuilder a) {
    char[] s = a.toString().toCharArray();
    char[] t = new char[] {'1'};
    int i = s.length - 1;
    int j = t.length - 1;
    int carry = 0;
    StringBuilder sb = new StringBuilder();

    while (i >= 0 || j >= 0 || carry > 0) {
        int aNo = i >= 0 ? s[i] - '0' : 0;
        int bNo = j >= 0 ? t[j] - '0' : 0;

        int sum = aNo + bNo + carry;
        int dig = sum % 2;
        carry = sum / 2;
        i--;
        j--;
        sb.append((char)(dig + '0'));
    }

    sb.reverse(); 
    a.setLength(0); 
    a.append(sb);  
}
}