package tree;

import java.util.HashMap;

public class UniqueBinarySearchTrees {
    private int sum = 0;
    private HashMap<Integer, Integer> resultMap = new HashMap<>();
    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        System.out.println(uniqueBinarySearchTrees.numTrees(3));
    }

    public int numTrees(int n) {
        if (n == 0) return 0;
        resultMap.put(0,1);
        resultMap.put(1,1);
       return calcCount(n);
    }

    // 公式 f(n-i)*f(i-1), i++
    private int calcCount(int n) {
        if (resultMap.containsKey(n)) return resultMap.get(n);
        sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += calcCount(n - i) * calcCount(i - 1);
        }
        resultMap.put(n, sum);
        return sum;
    }
}
