package LeetCode;

import java.util.*;

public class EqualOccurance {
    public static void main(String[] args) {
        String s = "mmmymmbymbbbmybyymmybyybyyymbybmbbyyybbmybybbbmbmbyybbmbybyybyyybymbmmbmmmbmbbybmmbbmbbyymbmmyybbyyybmbmyymmybymybmmmybbmyyyybbbyyymyymyyymmmbybybbmmmbmbbyyymbbyyyybybbmmybbmbbbbybbbmbyyybyybmbmmbybmmbymbmmbymybybmymmyybmmyymbybmybmmyyymbbbmmmmmmbybybmbmymbbbbmymbbmymmmmmyyymyymmymbbyyyyyybymyymbmyymybybbbmbbyymmbyybmmbmbyybbymmybmybyybbyybmbybmmmymbymmmyyyybymmbmmybmymmyymbbymbybymbmmmbbmmbymmbymybbybybmymbbmyyybmymmybbmbmbbbybmbbmmbybybmbymmmmmbmmmymmymbmbmmyybybmmbmybbmybyybmbyymmy";
        System.out.println(areOccurrencesEqual(s));
    }
    static boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        ArrayList<Integer> li = new ArrayList<>();
        for(Character key : map.keySet()) {
            li.add(map.get(key));
        }
        int i = 0;
        while (i < li.size()-1 && Objects.equals(li.get(i), li.get(i + 1))) {
            i++;
        }
        if(li.size() == 2) {
            return li.get(0).intValue() == li.get(1).intValue();
        }
        return i >= li.size()-1;
    }
}
