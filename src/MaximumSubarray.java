
/**
 * 最长子序列和
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums =  {-2,-1,0};
        System.out.println(maxSubArray(nums));
    }

    /**
     *这题用分治 可以再缩短时间
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0, maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 如果比当前的大就交换
            if (sum > maxSum) {
                maxSum = sum;
            }

            // 如果小于0，就从头开始，都是负数了加上去更加小，下一个直接从头开始
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
