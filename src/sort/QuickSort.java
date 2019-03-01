package sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
       int[] data = {7,5,3,2,3,4};
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
        int i = p, j = r - 1;
        while (i < j) {
            // i从左边找，如果比基准值大交换元素
            while (data[i] <= flag && i < j) {
                i++;
            }
            swap(i, j, data);

            // j从右边找，如果比基准值小交换元素
            while (data[j] >= flag && i < j) {
                j--;
            }
            swap(i,j,data);
        }
        // 基准值放入数组中间
        swap(j, r, data);
        Arrays.sort(data);
        return j;
    }

    private static void swap(int i, int j, int[] data) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
