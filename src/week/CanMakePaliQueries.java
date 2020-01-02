package week;

import java.util.ArrayList;
import java.util.List;

public class CanMakePaliQueries {
    public static void main(String[] args) {
        String a = "abcda".substring(3,4);
        System.out.println(a);
        int[][] queries = {{0,3,1}};
        canMakePaliQueries("hunu", queries).forEach(System.out::println);
    }
    public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> results = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            boolean flag = true;
            char[] a = s.substring(queries[i][0], queries[i][1]+1).toCharArray();
            int skip = queries[i][2];
            for (int j = 0; j < a.length / 2; j++) {
                if (a[j] != a[a.length -1 - j] && skip == 0) {
                    flag = false;
                    break;
                }
                if (a[j] != a[a.length -1 -j] && skip > 0) {
                    skip = skip -1;
                }
            }
            results.add(flag);
        }
        return results;
    }
}
