package heap;

import java.util.ArrayList;
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
public class MedianFinderOne {
    public static void main(String[] args) {
        MedianFinderOne medianFinder = new MedianFinderOne();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.addNum(7);
        System.out.println(medianFinder.findMedian());
    }

    ArrayList<Integer> bigHeap;
    ArrayList<Integer> smallHeap;
    public MedianFinderOne() {
        bigHeap = new ArrayList<>();
        smallHeap = new ArrayList<>();
        bigHeap.add(Integer.MIN_VALUE);
        smallHeap.add(Integer.MIN_VALUE);
    }

    public void addNum(int num) {
        // 数据为空直接加入大顶堆
        if (bigHeap.size() == 1) {
            bigHeap.add(num);
            return;
        }
        if (smallHeap.size() == 1) {
            // 如果大顶堆堆顶>小顶堆堆顶 交换顺序
            if (bigHeap.get(1) > num) {
                int tmp = bigHeap.get(1);
                bigHeap.set(1, num);
                smallHeap.add(tmp);
                return;
            }
            smallHeap.add(num);
            return;
        }
        // 如果大于小顶堆堆顶，则加到小顶堆
        if(num > smallHeap.get(1)) {
            addSmallHeap(num);
        } else {
            addBigHeap(num);
        }

        if (smallHeap.size() > bigHeap.size()) {
            addBigHeap(delSmallHeapTop());
            return;
        }

        if (bigHeap.size() - smallHeap.size() > 1) {
            addSmallHeap(delBigHeapTop());
        }
    }

    public double findMedian() {
        int dataSize = bigHeap.size() + smallHeap.size() - 2;
        if (dataSize == 0) return 0;
        if (dataSize % 2 == 0) {
            return (bigHeap.get(1) + smallHeap.get(1)) / 2.0;
        } else {
            return bigHeap.get(1);
        }
    }

    /**
     * 添加到大顶堆
     */
    private void addBigHeap(int num) {
        bigHeap.add(num);
        int i = bigHeap.size()-1;
        while (true) {
            // 和父节点比较， 比父节点大交换
            if (i / 2 > 0 && bigHeap.get(i/2) < bigHeap.get(i)) {
                swap(i / 2, i,bigHeap);
                i = i / 2;
            } else {
                break;
            }
        }
    }

    /**
     * 添加到小顶堆
     */
    private void addSmallHeap(int num) {
        smallHeap.add(num);
        int i = smallHeap.size()-1;
        while (true) {
            // 比父节点小的交换
            if (i / 2 > 0 && smallHeap.get(i/2) > smallHeap.get(i)) {
                swap(i / 2, i,smallHeap);
                i = i / 2;
            } else {
                break;
            }
        }
    }

    /**
     * 删除堆顶元素
     */
    private int delBigHeapTop() {
        int top = bigHeap.get(1);
        bigHeap.set(1, bigHeap.get(bigHeap.size()-1));
        bigHeap.remove(bigHeap.size()-1);
        int i = 1;
        while (true) {
            int maxPos = i;
            if (i*2 < bigHeap.size() && bigHeap.get(i) < bigHeap.get(i*2)) {
                maxPos = i*2;
            }

            if (i*2+1 < bigHeap.size() && bigHeap.get(maxPos) < bigHeap.get(i*2+1)) {
                maxPos = i*2+1;
            }
            if (maxPos == i) {
                break;
            } else {
                swap(maxPos, i, bigHeap);
            }
            i = maxPos;
        }
        return top;
    }

    /**
     * 删除堆顶元素
     */
    private int delSmallHeapTop() {
        int top = smallHeap.get(1);
        smallHeap.set(1, smallHeap.get(smallHeap.size()-1));
        smallHeap.remove(smallHeap.size()-1);
        int i = 1;
        while (true) {
            int maxPos = i;
            if (i*2 < smallHeap.size() && smallHeap.get(i) > smallHeap.get(i*2)) {
                maxPos = i*2;
            }

            if (i*2+1 < smallHeap.size() && smallHeap.get(maxPos) > smallHeap.get(i*2+1)) {
                maxPos = i*2+1;
            }
            if (maxPos == i) {
                break;
            } else {
                swap(maxPos, i, smallHeap);
            }
            i = maxPos;
        }
        return top;
    }


    private void swap(int i, int j, List<Integer> heaps) {
        int tmp = heaps.get(i);
        heaps.set(i, heaps.get(j));
        heaps.set(j, tmp);
    }
}
