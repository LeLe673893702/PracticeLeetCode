import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid(")]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!characters.isEmpty()) {
                switch (s.charAt(i)) {
                    case ')':
                        if (characters.peek() == '(') {
                            characters.pop();
                            continue;
                        } else return false;
                    case ']':
                        if (characters.peek() == '[') {
                            characters.pop();
                            continue;
                        } else
                            return false;
                    case '}':
                        if (characters.peek() == '{') {
                            characters.pop();
                            continue;
                        } else
                            return false;
                }
            }
            characters.push(s.charAt(i));
        }
        return characters.isEmpty();
    }

}
