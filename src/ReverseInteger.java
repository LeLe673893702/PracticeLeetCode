import java.util.Stack;

/**
 * 反转整数
 * Input: -123
 * Output: -321
 *
 * Input: 120
 * Output: 21
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        if (x == 0) return 0;
        if (Math.abs(x) < 0) return 0;
        StringBuilder left = new StringBuilder(String.valueOf(Math.abs(x)));

        StringBuilder right = left.reverse();

        int i = 0;
        for (Character c : right.toString().toCharArray()) {
            if (c == '0') {
                i++;
            } else {
                break;
            }
        }
        System.out.println(right.substring(i, right.length()));
        long resultInt = Long.parseLong(right.substring(i, right.length()));
        if (x < 0) {
            if (-resultInt < Integer.MIN_VALUE) {
                return 0;
            } else  {
                return (int) -resultInt;
            }
        } else {
            if (resultInt > Integer.MAX_VALUE) {
                return 0;
            } else {
                return (int) resultInt;
            }
        }
    }
}
