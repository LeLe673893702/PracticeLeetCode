package array;

import java.util.Arrays;

/**
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
    public static int removeDuplicates(int[] nums) {
        int sum = 0;
        int index = -1;
        boolean first = true;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] = Integer.MAX_VALUE;
                sum++;
            }
            // 找到第一个重复项
            if (first) {
                index = i;
                first = false;
            }
        }

        // 如果没有重复项直接输出
        if (index == -1) {
            return nums.length - sum;
        }

        // 交换位置，把重复项移动到最后
        for (int i = index; i < nums.length -1; i++) {
            if (nums[i+1] != Integer.MAX_VALUE) {
                int swap = nums[i+1];
                nums[i+1] = nums[index];
                nums[index] = swap;
                index++;
            }

        }
        return nums.length - sum;
    }
}
