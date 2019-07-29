package week;

import java.util.ArrayList;
import java.util.List;

public class Tribonacci {
    public static void main(String[] args) {
        Tribonacci tribonacci = new Tribonacci();
        System.out.println(tribonacci.tribonacci(25));
    }
    List<Integer> results = new ArrayList<>(40);
    public int tribonacci(int n) {
        results.add(0);
        results.add(1);
        results.add(1);

        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        for (int i = 3; i <= n; i++ ) {
            results.add(results.get(i-1) + results.get(i-2) + results.get(i-3));
        }
        return results.get(results.size()-1);
    }
}
