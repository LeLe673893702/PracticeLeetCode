/**
 * 21.合并两个已经排序的列表
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);

        l1 = mergeTwoLists(l1,null);
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 != null && l2 == null) return l1;
        if (l1 == null && l2 != null) return l2;
        ListNode tmp, next, h1 = l1, h2 = l2;
        while (h1 != null && h2 != null) {
            // 尾部
            if (h1.next == null && h2.val >= h1.val) {
                  h1.next = h2;
                  h2 = h2.next;
                  h1.next.next = null;
            } else if (h2.val >= h1.val && h2.val <= h1.next.val) {
                // 插入中间
                tmp = h2;
                next = h1.next;
                h2 = h2.next;
                h1.next = tmp;
                tmp.next = next;
            } else if(h2.val < h1.val) {
                // 头部
                tmp = h2;
                h2 = h2.next;
                tmp.next = h1;
                h1 = tmp;
                l1 = tmp;
                continue;
            }
            h1 = h1.next;
        }

        return l1;
    }


}
