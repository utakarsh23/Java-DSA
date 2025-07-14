package LeetCode;

public class ProcessStringWithSpecialOperationsII {
    public static void main(String[] args) {
        System.out.println(processStr("##%##*js%#qxk%oe%tas#n%%%#x*%j#%#h%%######*bxp#p##i%u%%q#o#n#%*ca%#g#hjbz#d%%k%x%#%#y%*gw%q#f#%q*v#%koe%j%k#n#y#%#sm#et%jyo%#i*h#u##a%%i##%o#rd#j###xj%#h#%hn#%igde#nyt##bkgf%iuy%%%svgintn%w%q%%q%%%%s%*r%m%%mck%vkceo*%hk%%f%%fkak%fho%*y*%%%%h%rgomby%l*%%%lbwn%qc%%*%%pp%*%pu**u*%%vwqb%%vzsjh%eb*%%%%%vnm%zg%j*ouu%i%g%z%%m%%a*o%qxdj%%%%rl*bgxjefpg%%%%%y%t%*%vgsc*dl%%%nw*rq%c%hyk*ujru%%c%p%%a%a%%%%ii*%iq*%m%noajr%xbp%%i%*%q%po*e%qd%c*%ffkfk%lo%%%x*%%h*gr%%e*%sj%**h%lev%tl**%t%sl%oli%n*%%dgah", 0));
    }
    static public char processStr(String s, long k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            while (i < s.length() && s.charAt(i) == '*') {
                if(!sb.isEmpty()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                i++;
            } while (i < s.length() && s.charAt(i) == '#') {
                i++;
                String ss = sb.toString();
                sb.append(ss);
            }
            while (i < s.length() && s.charAt(i) == '%') {
                i++;
                sb.reverse();
            }
            while (i < s.length() && s.charAt(i) >= 97 && s.charAt(i) <= 122){
                sb.append(s.charAt(i));
                i++;
            }
        }
        char c = '.';
        if(sb.length() > k) {
            c = sb.toString().toCharArray()[(int) k];
        }
        return c;
    }

    public char processStr1(String s, long k) {
        long len = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) len++;
            else if (c == '*' && len > 0) len--;
            else if (c == '#') len *= 2;
        }
        if (k >= len) return '.';

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                if (k == len - 1) return c;
                len--;
            } else if (c == '*') {
                len++;
            } else if (c == '#') {
                len /= 2;
                if (k >= len) k -= len;
            } else if (c == '%') {
                k = len - 1 - k;
            }
        }
        return '.';
    }
}
