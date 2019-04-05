package sort;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab","ca"));
    }
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> SHashMap = new HashMap<>(s.length());
        HashMap<Character, Character> THashMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (SHashMap.containsKey(s.charAt(i))) {
                if (SHashMap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                SHashMap.put(s.charAt(i), t.charAt(i));
            }
            if (THashMap.containsKey(t.charAt(i))) {
                if (THashMap.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                THashMap.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }

    public static boolean bestAnswer(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            Integer a = m1.put(s1.charAt(i), i);
            Integer b = m2.put(s2.charAt(i), i);
//            if(m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
//                return false;
//            }
            System.out.println(a+"--"+b);
        }
        return true;
    }
}