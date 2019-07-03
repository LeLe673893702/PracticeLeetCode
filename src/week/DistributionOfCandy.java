package week;

import java.util.Arrays;

/**
 *排排坐，分糖果。
 *
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 *
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 *
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 *
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。
 * 注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 *
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数
 */
public class DistributionOfCandy {
    public static void main(String[] args) {
        DistributionOfCandy distributionOfCandy = new DistributionOfCandy();
        int[] res = distributionOfCandy.distributeCandies2( 10, 3);
        Arrays.stream(res).forEach(System.out::println);
    }
    // 方程 num_people^2/2 * x^2 + num_people/2 * x - candies = 0
    public int[] distributeCandies(int candies, int num_people) {
        int[] results = new int[num_people];
        double b = num_people / 2.0;
        double a = Math.pow(num_people, 2)/2.0;
        double x1 = (-b + Math.sqrt(b*b - 4 * a * -candies)) / (2.0 * a);
        double x2 = (-b - Math.sqrt(b*b - 4 * a * -candies)) / (2.0 * a);
        int sum = 0;

        for (int i = 0; i < num_people; i++) {
            int shareCandies = (2*i +2 + num_people*(int)x1 - num_people)*(int)x1 / 2;
            results[i] = shareCandies;
            sum += shareCandies;
        }
        int remain = candies - sum;
        for (int i = 0; i < num_people; i++) {
            int shareCandies = num_people * (int)x1 + i + 1;
            if (remain < shareCandies) {
                results[i] += remain;
            } else {
                results[i] += shareCandies;
            }
            remain -= shareCandies;
            if (remain < 0) {
                break;
            }
        }

        return results;
     }

    public int[] distributeCandies2(int candies, int num_people) {
        int[] results = new int[num_people];
        int count = 1;
        int sum = 0;
        for (int i = 0; i < num_people; i++) {
            if (sum+count >= candies) {
                results[i] += candies - sum;
                break;
            }
            results[i] += count;
            sum += count;
            count ++;
            if (i == num_people-1) {
                i = -1;
            }
        }
        return results;
    }
}
