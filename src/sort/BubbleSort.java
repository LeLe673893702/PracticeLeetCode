package sort;

import java.util.Arrays;


public class BubbleSort {
    public static void main(String[] args) {
        int[] data = {6,5,4,3,2,1};
        bubbleSort(data);
        Arrays.stream(data).forEach(System.out::println);
    }
    /*
    * 1. 数组从小到大开始排序，外层循环控制每趟比较次数
    * 2. 内层循环是前后两两进行比较
    */
    private static void bubbleSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length-i-1; j++) {
                if (data[j] > data[j+1]) {
                    int tmp = data[j+1];
                    data[j+1] = data[j];
                    data[j] = tmp;
                }
            }
        }
    }
}
