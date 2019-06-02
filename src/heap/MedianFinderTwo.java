package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
public class MedianFinderTwo {
    public static void main(String[] args) {
        MedianFinderTwo medianFinder = new MedianFinderTwo();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.addNum(7);
        System.out.println(medianFinder.findMedian());
    }
    PriorityQueue<Integer> firstQueue,lastQueue;
     public MedianFinderTwo() {
        firstQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        lastQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
     }

    public void addNum(int num) {
        if (firstQueue.isEmpty()) {
            firstQueue.add(num);
            return;
        }

        if (num <= firstQueue.peek()) {
            firstQueue.add(num);
        } else {
            lastQueue.add(num);
        }

        if (firstQueue.size() - lastQueue.size() > 1) {
            lastQueue.add(firstQueue.poll());
            return;
        }

        if (firstQueue.size() < lastQueue.size()) {
            firstQueue.add(lastQueue.poll());
        }
     }

    public double findMedian() {
         int numSize = firstQueue.size() + lastQueue.size();
         if (numSize == 0) return -1;
        if (numSize % 2 == 0) {
            return (firstQueue.peek() + lastQueue.peek()) / 2.0;
        } else {
            return firstQueue.peek();
        }
    }
}
