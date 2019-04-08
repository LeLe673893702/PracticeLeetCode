import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * 三数相加
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {1,-1,-1,0};
        threeSum(nums).stream().forEach(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> list) {
                list.forEach(System.out::println);
            }
        });
    }

    /**
     * 三种情况
     * 1.两个负数一个正数
     * 2.两个正数一个负数
     * 3.一正一负一个0
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int l = i+1;
            int h = nums.length - 1;
            if (i > 0 && nums[i-1] == nums[i]) continue;
            while (l < h) {
                if (nums[i] + nums[l] + nums[h] == 0) {
                    results.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    while (l < h && nums[h-1] == nums[h]) h--;
                    while (l < h && nums[l + 1] == nums[l]) l++;
                    h--;
                    l++;
                } else if (nums[l] + nums[h] > -nums[i]) {
                    h--;
                } else {
                    l++;
                }
            }
        }

        return results;
    }

}
