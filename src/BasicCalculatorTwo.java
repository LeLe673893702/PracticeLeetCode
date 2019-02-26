import javax.print.attribute.standard.NumberUp;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BasicCalculatorTwo {
    public static void main(String[] args) {
        System.out.print(calculate("1+2*5/3+6/4*2"));
    }

    public static int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operationStack = new Stack<>();
        int sum = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (Character.isDigit(s.charAt(i))) {
                sum = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sum = sum * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                numStack.push(sum);
            } else {
                if (!operationStack.isEmpty() && getOperationLevel(s.charAt(i)) < getOperationLevel(operationStack.peek())) {
                    while (!operationStack.isEmpty()) {
                        result = calc(operationStack.pop(), numStack.pop(), numStack.pop());
                        numStack.push(result);
                    }
                }
                if (!operationStack.isEmpty() && getOperationLevel(s.charAt(i)) == getOperationLevel(operationStack.peek())) {
                    result = calc(operationStack.pop(), numStack.pop(), numStack.pop());
                    numStack.push(result);
                }
                operationStack.push(s.charAt(i));
            }
        }

        while (!operationStack.isEmpty()) {
            result = calc(operationStack.pop(), numStack.pop(), numStack.pop());
            numStack.push(result);
        }
        return numStack.pop();
    }

    public static int getOperationLevel(char operation) {
        switch (operation) {
            case '+':
                return 0;
            case '-':
                return 0;
            case '*':
                return 1;
            default:
                return 1;
        }
    }

    public static int calc(char operation, int b, int a) {
        switch (operation) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            default:
                return a / b;
        }
    }
}
