package week;

import java.util.*;

public class ArrayRelatedSort {
    public static void main(String[] args) {
        ArrayRelatedSort arrayRelatedSort = new ArrayRelatedSort();
        int[] a1= {2,3,1,20,23,7,29,23,3,2,4,6,7,9,2,19};
        int[] a2 = {2,1,4,3,9,6};

        for (int i :  arrayRelatedSort.relativeSortArray(a1, a2)) {
            System.out.print(i + " ");
        }
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> list1 = new ArrayList<>();
        for (int i : arr1) {
            list1.add(i);
        }
        list1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int index1 = -1;
                int index2 = -1;
                for (int i = 0; i < arr2.length; i++) {
                    if (o1 == arr2[i]) {
                        index1 = i;
                    }
                    if (o2 == arr2[i]) {
                        index2 = i;
                    }
                }
                if (index1 > index2) return 1;
                else if (index1 < index2) return -1;
                else {
                    if (o1 > o2) {
                        return -2;
                    }
                    else if (o1 < o2) {
                        return 2;
                    }
                    else return 0;
                }
            }
        });
        int k = 0;

        int[] results = new int[arr1.length];
        for (int i =0; i < list1.size(); i++) {
           if (list1.get(i) == arr2[0]) {
               break;
           }
           k++;
        }
        for (int j = 0; j < list1.size(); j++) {
            if (j >= k) {
                results[j-k] = list1.get(j);
            } else {
                results[list1.size() - j-1] = list1.get(j);
            }
        }
        return results;
    }
}
