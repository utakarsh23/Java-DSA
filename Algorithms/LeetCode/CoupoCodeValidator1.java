package LeetCode;

import java.util.*;

public class CoupoCodeValidator1 {
    // static String check = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890_";
    static char[] ch = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890_".toCharArray();
    static Set<Character> set = new HashSet<>();
    static {
        for(char c : ch) set.add(c);
    }

    static List<String> businessesList = List.of("electronics", "grocery", "pharmacy", "restaurant");


    class Coupon {
        boolean isActive;
        String business;
        String code;

        public Coupon(String code, String business, boolean isActive) {
            this.code = code;
            this.business = business;
            this.isActive = isActive;
        }
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        Coupon[] coupon = new Coupon[n];
        for(int i =0; i < n; i++) {
            coupon[i] = new Coupon(code[i], businessLine[i], isActive[i]);
        }
        Arrays.sort(coupon, (a, b) -> {
            int compared = a.business.compareTo(b.business);
            return compared != 0 ? compared : a.code.compareTo(b.code);
        });

        List<String> list = new ArrayList<>();
        for(Coupon cp : coupon) {
            if(check(cp)) list.add(cp.code);
        }
        return list;
    }

    private boolean check(Coupon c) {
        if(!c.isActive) return false;
        if(c.code.isEmpty()) return false;
        if(!businessesList.contains(c.business)) return false;
        for(char chars : c.code.toCharArray()) {
            if(!set.contains(chars)) return false;
        }
        return true;
    }
}
