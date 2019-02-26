public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,9,4,3,2};
        firstMissingPositive(nums);
    }
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }else{
                i++;
            }
        }
        i = 0;
        while(i < nums.length && nums[i] == i+1) i++;
        return i+1;
    }

    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}