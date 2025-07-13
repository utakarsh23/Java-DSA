package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoupoCodeValidator {
    public static class coups {
        String code;
        String business;
        boolean isActive;

        public coups(String code, String business, boolean isActive) {
            this.code = code;
            this.business = business;
            this.isActive = isActive;
        }
    }
    public static void main(String[] args) {
        System.out.println(validateCoupons(new String[] {"GROCERY15","ELECTRONICS_50","DISCOUNT10"}, new String[] {"grocery","electronics","invalid"}, new boolean[] {false,true,true}));
    }
    static public List<String> validateCoupons1(String[] code, String[] businessLine, boolean[] isActive) {
        String check = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890_";
        List<String> li = new ArrayList<>();
        List<String> checkBus = List.of("electronics", "grocery", "pharmacy", "restaurant");

        for(int i = 0; i < code.length; i++) {
            String codes = code[i].trim();
            if(!codes.isEmpty() && checkBus.contains(businessLine[i])) {
                int j = 0;
                for(char c : codes.toCharArray()) {
                    if(!(check.indexOf(c) < 0) && isActive[i] && j++ == codes.length()-1) {
                        li.add(code[i]);
                    }
                }
            }
        }
        Collections.sort(li);
        return li;
    }

    static public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> checkBus = List.of("electronics", "grocery", "pharmacy", "restaurant");
        coups[] coup = new coups[code.length];
        for (int i = 0; i < coup.length; i++) {
            coup[i] = new coups(code[i], businessLine[i], isActive[i]);
        }
        List<String> li = new ArrayList<>();

        Arrays.sort(coup, (a, b) -> {
            int cmp = a.business.compareTo(b.business);
            if (cmp != 0) return cmp;
            return a.code.compareTo(b.code);
        });
        for(coups co : coup) {
            if(co.isActive) {
                if(co.code != null && !co.code.isEmpty() && checkBus.contains(co.business)) {
                    boolean abs = true;
                    for(char c : co.code.toCharArray()) {
                        if(!((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || c == 95)) {
                            abs = false;
                            break;
                        }
                    }
                    if(abs) {
                        li.add(co.code);
                    }
                }
            }
        }
        return li;
    }
}
