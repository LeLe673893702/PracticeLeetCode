package sort;

import java.util.*;
/**
 * Leetcode:HashMap题解，在数组中找到
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strings = {"ray","cod","abe","ned","arc","jar","owl","pop","paw","sky","yup",
                "fed","jul","woo","ado","why","ben","mys","den","dem",
                "fat","you","eon","sui","oct","asp","ago","lea","sow",
                "hus","fee","yup","eve","red","flo","ids","tic","pup","hag","ito","zoo"};
        List<List<String>> results = groupAnagrams(strings);
        results.stream().forEach(list-> {
            list.forEach(System.out::print);
            System.out.println();
        });
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> resultHashMap = new HashMap<>();
        Set<String> keySet = resultHashMap.keySet();
        for (String str : strs) {
            boolean find = false;
            if (keySet.size() == 0) {
                List<String> value = new ArrayList<>();
                value.add(str);
                resultHashMap.put(str, value);
                continue;
            }
            for (String key: keySet) {
                if (isSame(str, key)) {
                    resultHashMap.get(key).add(str);
                    find = true;
                    break;
                }
            }
            if (!find) {
                List<String> value = new ArrayList<>();
                value.add(str);
                resultHashMap.put(str, value);
            }
        }
        return new ArrayList<>(resultHashMap.values());
    }

    public static boolean isSame(String str1, String str2) {
        if (str1.length() == str2.length()) {
            boolean[] flags = new boolean[str2.length()];
            for (int i = 0; i < str1.length(); i++) {
                boolean find = false;
                for (int j = 0; j < str2.length(); j++) {
                    if (flags[j]) {
                        continue;
                    }
                    if (str2.charAt(j) == str1.charAt(i)) {
                        flags[j] = true;
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
