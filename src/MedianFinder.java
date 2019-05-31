import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 295.数据中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class MedianFinder {
    ArrayList<Integer> bigHeap;
    ArrayList<Integer> smallHeap;
    public int bigHeapSize = 1;
    public int smallHeapSize = 1;

    public static void main(String[] args) {

    }

    public MedianFinder() {
        bigHeap = new ArrayList<>();
        smallHeap = new ArrayList<>();
        bigHeap.add(0);
        smallHeap.add(0);
    }

    public void addNum(int num) {

    }

    public double findMedian() {

    }

    public void buildBigHeap(int key) {
        bigHeap.add(key);
        bigHeapSize++;
        int i = bigHeapSize-1;
        int maxHeap = bigHeapSize-1;
        while (true) {
            // 和父节点比较， 比父节点大交换
            if (i / 2 > 0 && bigHeap.get(i/2) < bigHeap.get(i)) {
                maxHeap = i / 2;
                swap(maxHeap, i,bigHeap);
            }

            if ((i-1)/2 == i/2 && bigHeap.get(i/2) < bigHeap.get(i-1)) {
                swap(maxHeap, i-1, bigHeap);
            }

        }
    }

    public void buildSmallHeap() {

    }

    public void swap(int i, int j, List<Integer> heaps) {
        int tmp = heaps.get(i);
        heaps.set(i, heaps.get(j));
        heaps.set(j, tmp);
    }
}
