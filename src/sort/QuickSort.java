package sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] data = {5, 4, 3, 2, 1};
        quickSort(data, 0, data.length - 1);
        Arrays.stream(data).forEach(System.out::println);
    }

    /**
     * 14325
     *
     * 14325
     *
     * 12345
     *
     * 13245
     */
    private static void quickSort(int[] data, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = sort(data, p, r);
        // 排序基准值左边的元素
        quickSort(data, p, q - 1);
        // 排序基准值右边的元素
        quickSort(data, q + 1, r);
    }

    private static int partition(int[] data, int p, int r) {
        // 基准值
        int flag = data[p];
        int i = p+1 , j = r;
        while (true) {
            // i从左边找，如果比基准值大直接赋值
            while (data[i] < flag)  {
                if (i == r) break;
                i++;
            }

            // j从右边找，如果比基准值小直接赋值
            while (data[j] > flag) {

                if (j == p) break;
                j--;
            }
            if (i < j) {
                swap(i, j, data);
            } else {
                break;
            }
        }
        // 基准值放入数组中间
        swap(j, p, data);
        return j;
    }

    /**
     * 挖坑
     */
    private static int sort(int[] arr, int low, int high){
        if(arr.length <= 0) return -1;
        if(low >= high) return -1;
        int l = low;
        int r = high;

        int pivot = arr[l];    //挖坑1：保存基准的值
        while(l < r){
            while(l < r && arr[r] >= pivot){  //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
                r--;
            }
            arr[l] = arr[r];
            while(l < r && arr[l] <= pivot){   //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;   //基准值填补到坑3中，准备分治递归快排
        return l;
    }

    public static void swap(int i, int j, int[] data) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
