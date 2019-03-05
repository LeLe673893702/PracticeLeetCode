package sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
       int[] data = {5,4,3,2,1};
        quickSort(data, 0, data.length-1);
        Arrays.stream(data).forEach(System.out::println);
    }

    private static void quickSort(int[] data, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(data, p, r);
        // 排序基准值左边的元素
        quickSort(data, p ,q-1);
        // 排序基准值右边的元素
        quickSort(data, q+1, r);
    }

    private static int partition(int[] data, int p, int r) {
        // 基准值
        int flag = data[r];
        int i = p, j = r;
        while (i < j) {
            // i从左边找，如果比基准值大直接赋值
            while (data[i] <= flag && i < j) {
                i++;
            }
            if (i < j)
                data[j] = data[i];

            // j从右边找，如果比基准值小直接赋值
            while (data[j] >= flag && i < j) {
                j--;
            }
            if (i < j)
                data[i] = data[j];
        }
        // 基准值放入数组中间
        data[i] = flag;
        return i;
    }
}
