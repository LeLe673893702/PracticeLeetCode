package week;

import java.util.*;

public class CanMakePalindromeFromSubstring {
    public static void main(String[] args) {
        int[][] queries = {
                {3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        canMakePaliQueries("abcda", queries).forEach(System.out::println);
    }
    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> results = new ArrayList<>(queries.length);
        char[] words  =s.toCharArray();
        HashSet<Character> hashSet = new HashSet<>(26);

        for (int[] query : queries) {
            if (query[2] > 13){
                results.add(true);
                continue;
            }
            hashSet.clear();
            for (int j = query[0]; j <= query[1]; j++) {
                if (!hashSet.add(words[j])) hashSet.remove(words[j]);
            }
            results.add(hashSet.size()/2 > query[2]);
        }

        return results;
    }



}
