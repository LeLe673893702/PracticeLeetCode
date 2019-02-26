import java.util.HashMap;

/**
 * 169.求众数
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> results = new HashMap<>();
        for (int num : nums) {
            if (results.containsKey(num)) {
                results.put(num,results.get(num) + 1);
            } else {
                results.put(num, 1);
            }
        }

        int max = 0;
        int num = 0;
        for (Integer key : results.keySet()) {
            if (results.get(key) > max) {
                num = key;
                max = results.get(key);
            }
        }

        return num;
    }
}
