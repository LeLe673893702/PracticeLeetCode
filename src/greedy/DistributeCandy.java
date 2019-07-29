package greedy;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 */
public class DistributeCandy {
    public static void main(String[] args) {
        int[] ratings = {29,51,87,87,72,12};
        DistributeCandy distributeCandy = new DistributeCandy();
        System.out.println(distributeCandy.candy(ratings));
    }

    public int candy(int[] ratings) {
        int[] results = new int[ratings.length];
        Stack<Integer> stack = new Stack<>();
        results[0] = 1;
        stack.push(0);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i-1]) {
                results[i] = 1;
                stack.push(i);
                continue;
            }
            if (ratings[i] >= ratings[i-1]) {
                getStackNum(results, stack);

                if (ratings[i] > ratings[i-1]) {
                    results[i] =results[i-1] +1;
                }
                if (ratings[i] == ratings[i-1]) {
                    results[i] = 1;
                }
                stack.push(i);
            }
        }

        getStackNum(results, stack);
        int sum = 0;
        for (int i = 0; i < results.length; i++) {
            sum += results[i];
        }
        return sum;
    }

    private void getStackNum(int[] results, Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int num = results[stack.peek()];
            while (!stack.isEmpty()) {
                if (stack.peek()+1 < results.length && results[stack.peek()] <= results[stack.peek() + 1]) {
                    results[stack.pop()] = num;
                } else {
                    stack.pop();
                }
                num++;
            }
        }
    }
}
