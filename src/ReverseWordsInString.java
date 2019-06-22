import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
