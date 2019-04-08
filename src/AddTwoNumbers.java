/**
 * 链表两个节点相加，生成一个新链表
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(8);
//        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(1);
//        head2.next = new ListNode(6);
//        head2.next.next = new ListNode(6);

        ListNode result = addTwoNumbers(head1, head2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1, h2 = l2;
        int add = 0;
        while (h1 != null && h2 != null) {
            int sum = add + h1.val +h2.val;
            // add用来进位
            add = sum >= 10 ? 1 : 0;
            // 不用创建新链表，直接把原有链表更新为两个节点相加的值
            h1.val = sum%10;
            h2.val = sum%10;
            // 如果是最后一个节点，产生进位
            if (h1.next == null && add == 1) {
                h1.next = new ListNode(1);
                add = 0;
            } else if (h2.next == null && add == 1) {
                h2.next = new ListNode(1);
                add = 0;
            }
            h1 = h1.next;
            h2 = h2.next;
        }

        if (h1 != null) {
            return l1;
        } else {
            return l2;
        }
    }
}
