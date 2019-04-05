/**
 * 二分查找
 */
public class BinarySearch {
    private int[] data;

    public int bSearch(int[] data, int value) {
        int low = 0;
        int high = data.length-1;
        while (low <= high) {
            int mid = (low+high)/2;

            if (data[mid] == value) {
                return mid;
            } else if (data[mid] > value) {
                high = mid-1;
            } else  {
                low = mid+1;
            }
        }

        return -1;
    }
}
