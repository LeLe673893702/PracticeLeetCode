package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 151. Reverse Words in a String
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 */
public class ReverseWordsInString {
    public static void main(String[] args) {
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        String s = reverseWordsInString.reverseWords("    hello world!     ");
        System.out.println(s);
    }
    public String reverseWords(String s) {
        if (s.isEmpty()) return s;
        Pattern pattern = Pattern.compile("[ ]+");
        Matcher matcher = pattern.matcher(s);
        String[] words = s.split(" ");
        StringBuilder reversString = new StringBuilder(words.length);
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].isEmpty()) {
                continue;
            }
            reversString.append(words[i]);

            reversString.append(" ");
        }
        if (reversString.length() != 0) {
            return reversString.delete(reversString.length()-1, reversString.length()).toString();
        }
        return reversString.toString();
    }
}
