import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens =  {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> calcStack = new Stack<>();
        if (tokens.length == 0) return -1;
        if (!isDigit(tokens[0])) calcStack.push(0);
        for (String token : tokens) {
            if (isDigit(token)) {
                calcStack.push(Integer.valueOf(token));
            } else {
                calcStack.push(calc(calcStack.pop(), calcStack.pop(), token));
            }
        }
        return calcStack.pop();
    }

    public static boolean isDigit(String token) {
        return !"+".equals(token) && !"-".equals(token)
        && !"*".equals(token) && !"/".equals(token);
    }

    public static int calc(int a, int b, String operation) {
        if ("+".equals(operation)) {
            return a+b;
        } else if ("-".equals(operation)) {
            return b-a;
        } else if ("*".equals(operation)) {
            return a*b;
        } else {
            return b/a;
        }

    }
}
