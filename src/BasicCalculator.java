import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 加减计算器，需要考虑括号
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */
public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("(1)"));
    }
    public static int calculate(String s) {
        List<String> nums = new ArrayList<>();
        Stack<Character> operationStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        if (s.isEmpty()) return -1;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            nums.add("0");
        }
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                if (Character.isDigit(s.charAt(i))) {
                    int sum = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        sum = sum * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    i--;
                    nums.add(String.valueOf(sum));
                }
            } else {
                if (s.charAt(i) == '+' || s.charAt(i) == '-')  {
                    if (!operationStack.isEmpty() && operationStack.peek() != '(')
                        nums.add(String.valueOf(operationStack.pop()));
                    operationStack.push(s.charAt(i));
                }
                else if (s.charAt(i) == '(') {
                    operationStack.push(s.charAt(i));
                }
                else if (s.charAt(i) == ')') {
                    while (operationStack.peek() != '(') {
                        nums.add(String.valueOf(operationStack.pop()));
                    }
                    operationStack.pop();
                }
            }
        }
        while (!operationStack.isEmpty()) {
            nums.add(String.valueOf(operationStack.pop()));
        }

        for (String num : nums) {
            if (num.equals("+") || num.equals("-")) {
                numStack.push(calc(numStack.pop(), numStack.pop(), num));
            } else {
                numStack.push(Integer.parseInt(num));
            }
        }
        return numStack.pop() ;
    }


    public static int calc(int a, int b, String operation) {
        if (operation.equals("+")) {
            return a + b;
        } else {
            return b-a;
        }
    }
}
