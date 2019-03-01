package sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data = {3,2,1};
        int[] sortArray = sortedSquares(data);
        Arrays.stream(sortArray).forEach(System.out::println);
    }
    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        sort(0, A.length-1, A);

        return A;
    }

    public static void sort(int p, int r, int[] data) {
        if (p >= r) return;
        int  q = (p+r)/ 2;

        // 先排队左边
        sort(p, q, data);
        // 再排队右边
        sort(q+1, r, data);
        // 最后合并
        merge(data, p, q, r);
    }

    public static void merge(int[] data, int p, int q, int r) {
        int[] tmp = new int[r-p+1];
        int i = p, j = q+1, k;
        // 合并排序
        for (k = 0; i <= q && j <= r; k++) {
            if (data[i] <= data[j]) {
                tmp[k] = data[i];
                i++;
            } else {
                tmp[k] = data[j];
                j++;
            }
        }

        // 加入左边数组多余元素
        for (; i <= q; i++, k++) {
            tmp[k] = data[i];
        }
        // 加入右边数组多余元素
        for (; j <= r; j++, k++) {
            tmp[k] = data[j];
        }

        for (int z = 0; z <tmp.length; z++) {
            data[p++] = tmp[z];
        }
    }
}
