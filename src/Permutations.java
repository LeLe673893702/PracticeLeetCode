import java.util.ArrayList;
import java.util.List;

/**
 * 46.数组全排列,数组中的数字均不相同
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {
    private List<List<Integer>> group = new ArrayList<>();
    private int size = 0;
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1,2,3,4};
        permutations.permute(nums);

        permutations.group.forEach(resluts->{
            resluts.forEach(System.out::print);
            System.out.println();
        });
    }

    public List<List<Integer>> permute(int[] nums) {
        size = nums.length;
        List<Integer> results = new ArrayList<>();
        sort(results, nums);

        return group;
    }

    public void sort(List<Integer> results, int[] datas) {
        if (results.size() == size) {
            group.add(results);
            return;
        }

        for (int i = 0; i < datas.length; i++) {
            if (results.contains(datas[i])) {
                continue;
            }
            List<Integer> newResults = new ArrayList<>(results);
            newResults.add(datas[i]);
            sort(newResults, datas);
        }
    }

}
