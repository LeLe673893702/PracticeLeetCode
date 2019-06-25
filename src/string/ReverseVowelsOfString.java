package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 345
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 *
 */
public class ReverseVowelsOfString {
    public static void main(String[] args) {
        reverseVowels("hello");
        StringBuilder stringBuilder = new StringBuilder("hello");
        stringBuilder.delete(0,1);
        System.out.println(stringBuilder.toString());

    }
    public static String reverseVowels(String s) {
            Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int i = 0, j = s.length()-1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (vowel.contains(chars[i]) && vowel.contains(chars[j])) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j]  = tmp;
                i++;
                j--;
                continue;
            }

            if (!vowel.contains(chars[i])) {
                i++;
            }

            if (!vowel.contains(chars[j])) {
                j--;
            }
        }
        return new String(chars);
    }
}
