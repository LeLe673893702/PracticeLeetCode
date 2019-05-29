package sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        HeapSort heapSort = new HeapSort();

        Arrays.stream(heapSort.sort(nums)).forEach(System.out::print);
    }
    public int[] sort(int[] nums) {
        int[] datas =  new int[nums.length+1];
        for (int i = 1; i < datas.length; i++) {
            datas[i] = nums[i-1];
        }
        int n = datas.length;



        // 第一个是最大的，把第一个放到最后一个上
        while (n > 1) {
            buildHeap(datas, n);
            swap(1, datas.length-1,datas);
            n--;
        }
        return datas;
    }

    /**
     * 创建大顶堆
     */
    private void buildHeap(int[] datas, int n) {
        for (int i = n / 2; i > 0; i--) {
            int maxPos = i;
            if (2*i < n && datas[i] < datas[i * 2]) {
                maxPos = 2*i;
            }

            if (2*i+1 < n && datas[i] < datas[i * 2 + 1]) {
                maxPos = 2*i+1;
            }

            // 相同就不需要交换了
            if (maxPos != i) {
                swap(i, maxPos, datas);
            }
        }
    }

    private void swap(int i, int j, int datas[]) {
        int tmp = datas[i];
        datas[i] = datas[j];
        datas[j] = tmp;
    }
}
