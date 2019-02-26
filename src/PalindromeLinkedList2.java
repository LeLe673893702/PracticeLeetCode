public class PalindromeLinkedList2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(2);
//        head.next.next.next.next.next = new ListNode(2);
//        head.next.next.next.next.next.next = new ListNode(1);
//        head.next.next.next.next.next.next.next = new ListNode(1);
        ListNode temp = head;
//        for (int i = 0; i < 5; i++) {
//            ListNode listNode = new ListNode(0);
//            temp.next = listNode;
//            temp = listNode;
//        }
//        temp.next = null;
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        // 0个结点和1个结点都返回true
        if (head == null || head.next == null) return true;
        if (head.next.next == null && head.next.val == head.val) return true;
        if (head.next.next == null) return false;
        /**
         * 慢指针走一步，快指针走两步，当快指针走到头，慢指针也走了一半了
         * 两种情况，奇数和偶数
         * 1->2->3->4 第一次：fast = 3， slow = 2， 第二次：fast = null , slow = 3，结束
         * 1->2->3->4->5，第一次fast = 3，slow = 2， 第二次：fast = 5，slow = 3，结束
         */
        while (fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        slow = reverse(slow);

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode next, pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
