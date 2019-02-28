package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
       int[] data = {7,5,3,2,3,4};
        quickSort(data, 0, data.length-1);
        Arrays.stream(data).forEach(System.out::println);
        String text = "0012345678911";
        if (text.length() > 12) {
            System.out.println(text.substring(0, 12));
        }
    }

    private static void quickSort(int[] data, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(data, p, r);

        quickSort(data, p ,q-1);
        quickSort(data, q+1, r);

    }

    private static int partition(int[] data, int p, int r) {
        int flag = data[r];
        int i = p, j = r - 1;
        while (i < j) {
            while (data[i] <= flag && i < j) {
                i++;
            }
            swap(i, j, data);
            while (data[j] >= flag && i < j) {
                j--;
            }
            swap(i,j,data);
        }
        swap(j, r, data);
        return j;
    }

    private static void swap(int i, int j, int[] data) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
