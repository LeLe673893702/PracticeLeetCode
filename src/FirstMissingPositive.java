import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求最小正整数
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {-1,4,2,1,9,10};
        System.out.println(firstMissingPositive2(nums));
    }
    public static int firstMissingPositive1(int[] nums) {
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

    public static int firstMissingPositive2(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] > 0 && nums[i] < nums.length) {
                // 交换两个数字不能相等
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(i, nums[i] - 1, nums);
                    continue;
                }
            }
            i++;
        }

        for (int i = 0; i <nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
