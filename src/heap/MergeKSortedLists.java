package heap;

import utils.CreateLinkNode;
import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23.合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
//        [[1,4,5],[1,3,4],[2,6]]
        int[] a1 = {0};
        int[] a2 = {1};
        int[] a3 = {2};

        ListNode l1 = CreateLinkNode.getLinkedNode(a1);
        ListNode l2 = CreateLinkNode.getLinkedNode(a2);
        ListNode l3 = CreateLinkNode.getLinkedNode(a3);

        ListNode[] lists = {l1,l2,l3};

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode result = mergeKSortedLists.mergeKLists(lists);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private PriorityQueue<ListNode> priorityQueue;
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        priorityQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val > o2.val ? 1 : -1;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }
        if (priorityQueue.isEmpty()) return null;
        ListNode res = priorityQueue.peek();
        ListNode first = res;
        ListNode min = priorityQueue.poll();
        while (min != null && !priorityQueue.isEmpty()) {
            if (min.next != null) {
                // 如果小于堆顶元素，添加到有序列表中
                if (min.next.val <= priorityQueue.peek().val) {
                    min = min.next;
                } else {// 如果大于堆顶元素，则添加到堆中，找出最小元素
                    priorityQueue.add(min.next);
                    min = priorityQueue.poll();
                }
            } else { // 如果到其中有序链表的最后一个
                // 如果最后一个小于堆顶元素，直接加入新的有序链表
                if (min.val <= priorityQueue.peek().val) {
                    first.next = min;
                } else {
                    // 如果最后一个大于堆顶元素直接添加到堆中
                    priorityQueue.add(min);
                }
                // 最后一个无论是添加到有序列表中还是加入堆中，最终都要找出新的最小值
                min = priorityQueue.poll();
            }
               first.next = min;
                first = first.next;
        }
        // 如果还有剩余元素全部添加
        if (min != null) {
            min = min.next;
            first.next = min;
            first = first.next;
        }
        return res;
    }
}
