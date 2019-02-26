public class QuickSort {

    public void sort(int[] data, int q, int r) {
        if (q >= r) return;
        q = (q+r) / 2;
    }

    public int quick(int q, int r, int[] data) {
        int i = q;
        int j = r-1;
        int compare = data[r];
        while (i < r) {
            while (data[i] <= compare && i < r) {
                i++;
            }
            swap(i, j, data);


            while (data[j] <= compare && j < r) {
                j--;
            }
            swap(i, j, data);
        }
        swap(i, r, data);
        return i;
    }

    private void swap(int i, int j, int[] data) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
