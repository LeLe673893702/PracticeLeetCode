import com.sun.org.apache.regexp.internal.RE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 8. 字符串转换整数 (atoi)
 *
 */
public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("20000000000000000000"));
    }
    public int myAtoi(String str) {
        String first = "";
        Pattern pattern = Pattern.compile("((^\\s*)[+-]?[0-9]+)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            first = matcher.group(0);
        }
        first = first.trim();
        char[] integers = first.toCharArray();
        if (first.isEmpty()) {
            return 0;
        }

        int sum = 0;
        int radio = 1;
        // 判断第一个字符是+还是-，
        for (int i = 0; i < integers.length; i++) {
            if (i == 0) {
                if (integers[i] == '-') {
                    radio = -1;
                    continue;
                }
                if (integers[i] == '+') {
                    continue;
                }
            }
            // 判断是否超过max或min
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && integers[i]-'0' > 7)) {
                if (radio == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            sum = sum*10 + (integers[i]-'0')*radio;
        }

        return sum;
    }
}
