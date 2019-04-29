package tree;

import java.util.HashMap;

/**
 * 96、给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 把1...n每个数作为根节点，作为根节点左边的数组就是左子树，右边的数组就是右子树
 * 分别计算左边数组的组合数量和右边数组的组合数量，然后相乘
 * 公式 f(n-i)*f(i-1), i=1,i<=n,i++
 * 用hashMap保存防止重复计算
 */
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
