import java.util.HashMap;
import java.util.HashSet;

/**
 * 202
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(1));
    }
    public static boolean isHappy(int n) {
        HashSet<Integer> integers = new HashSet<>();

        int sum = 0;

        while (sum != 1) {
            sum = 0;
            while (n > 0) {
                int a = n % 10;
                sum += Math.pow(a, 2);
                n /= 10;
            }
            if (integers.contains(sum)) {
                return false;
            }
            integers.add(sum);
            n = sum;
        }

        return true;
    }
}
