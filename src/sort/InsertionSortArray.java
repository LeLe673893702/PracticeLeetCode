package sort;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class InsertionSortArray {

    public static void main(String[] args) {
        int[] data = {6,5,4,3,2,1};
        insertionSortList(data);
        Arrays.stream(data).forEach(System.out::println);
    }

    public  static void insertionSortList(int[] data) {
        // 分为2部分有序区和无序区
        for (int i = 0; i <data.length-1; i++) {
            int tmp = data[i+1];
            int j = i;
            for (; j >= 0; j--) {
                if (tmp < data[j]) {
                    data[j+1] = data[j];
                } else {
                    break;
                }
            }
            data[j+1] = tmp;
        }
    }
}
