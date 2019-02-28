import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("{{]}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();
        if (s.length() %2 == 1) {
            return false;
        } else {
            for (int i = 0; i < s.length() / 2; i++) {
                characters.push(s.charAt(i));
            }

            int j = s.length() / 2;
            while (!characters.isEmpty() && j < s.length()) {
                char c = characters.pop();
                if (Math.abs((int)c - (int)s.charAt(j)) != 2) {
                    return false;
                }
                j++;
            }
            return true;
        }
    }
}
