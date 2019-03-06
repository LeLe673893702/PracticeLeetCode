/**
 * 在有序循环数组中查询指定值（4,5,6,7,8,0,1,2）
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 递增数组-》左边有序，如果 nums[low]<= target <= nums[mid]，数字在左边，反之在右边
            if (nums[mid] >= nums[low]) {
                //
                if (target <= nums[mid] && target >= nums[low]) {
                    high = mid - 1;;
                } else {
                    low = mid + 1;
                }
                // 右边有序，如果 nums[mid]<= target <= nums[high]，数字在右边，反之在右边
            } else if (nums[mid] <= nums[high]) {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
