package week;

public class MaximumSum {
    public static void main(String[] args) {
        int nums[] = {8,-1,6,-7,-4,5,-4,7,-6};
        System.out.println(maximumSum(nums));
    }
    public static int maximumSum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int sum = 0, maxSum = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] < min) {
                min = arr[i];
            }
            // 如果比当前的大就交换
            if (sum > maxSum) {
                maxSum = sum;
            }

            // 如果小于0，就从头开始，都是负数了加上去更加小，下一个直接从头开始
            if (sum < 0) {
                if (min < 0) {
                    maxSum += Math.abs(min);
                }
                if (i < arr.length-1) {
                    min = arr[i+1];
                }
                sum = 0;
            }
        }
        return maxSum;
    }
}
