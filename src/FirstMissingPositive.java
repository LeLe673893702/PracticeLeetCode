import java.util.Arrays;

/**
 * 求最小正整数
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min = 1;
        for(int i = 0; i < nums.length; i++) {
            if (min < nums[i]) {
                continue;
            }
            if (min == nums[i]) {
                min = min+1;
            }
            if (min < nums[i]) {
                break;
            }
        }
        return min;
    }
}
