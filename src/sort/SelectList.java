package sort;

public class SelectList {
    private void selectList(int[] data) {
        // 每次从未排序的列表中找出最小的然后放在排序区的尾部
        for (int i = 0; i < data.length-1; i++) {
            int min = i;
            for (int j = i+1; j < data.length; j++) {
                if (data[min] > data[j]) {
                    min = j;
                }
            }
            int tmp = data[i];
            data[i] = data[min];
             data[min] = tmp;

        }
    }
}
