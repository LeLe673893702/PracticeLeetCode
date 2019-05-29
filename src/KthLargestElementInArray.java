import java.util.Arrays;

/**
 * 215.数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 */
public class KthLargestElementInArray {
    public static void main(String[] args) {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(kthLargestElementInArray.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {

        int[] datas = new int[nums.length + 1];
        for (int i = 1; i < datas.length; i++) {
            datas[i] = nums[i-1];
        }

        int n = datas.length;
        int order = k;
        buildBigHeap(datas, n);
        swap(n-1, 1, datas);
        n--;
        order--;
        while (order > 0) {
             deleteHeap(datas, n);

            // 第一个为最大值，放到最后面
            swap(n-1, 1, datas);
            order--;
            n--;
        }
        return datas[datas.length - k];
    }

    /**
     * 建立大顶堆，父节点值>子节点值
     */
    private void buildBigHeap(int[] datas, int n) {
        // 从第一个非叶子节点进行比较
        for (int i = n / 2; i > 0; i--) {
            int maxPos = i;

            // 和左节点比较
            if (2*i < n && datas[i] < datas[2*i]) {
                maxPos = 2 * i;
            }

            // 和右节点比较
            if (2*i + 1 < n && datas[maxPos] < datas[2*i+1]) {
                maxPos = 2 * i + 1;
            }

            if (maxPos != i) {
                swap(maxPos, i , datas);
            }
        }
    }

    private void deleteHeap(int[] datas, int n) {
        for (int i = 1; i <= n/2; i++) {
            int maxPos = i;

            // 和左节点比较
            if (2*i < n && datas[i] < datas[2*i]) {
                maxPos = 2 * i;
            }

            // 和右节点比较
            if (2*i + 1 < n && datas[maxPos] < datas[2*i+1]) {
                maxPos = 2 * i + 1;
            }

            if (maxPos != i) {
                swap(maxPos, i , datas);
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j, int datas[]) {
        int tmp = datas[i];
        datas[i] = datas[j];
        datas[j] = tmp;
    }
}
