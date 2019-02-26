import java.util.List;

public class PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
//        head.next.next.next.next.next = new ListNode(1);
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
        if (head == null) {
            return false;
        }
        // 1个结点就是
        if (head.next == null) {
            return true;
        }

        if (head.next.next == null && head.val == head.next.val) {
            return true;
        } else if (head.next.next == null) {
            return false;
        }

        ListNode mid = head;
        int size = 0;
        while (mid != null) {
            size++;
            mid = mid.next;
        }

        // 把mid移动到中点
        mid = head;
        for (int i = 0; i<size/2; i++) {
            mid = mid.next;
        }

        // 奇数的时候多走一步
        if (size % 2 != 0) {
            mid = mid.next;
        }

        // 开始反转
        ListNode pre = head, current = head.next, next = head.next.next;
        while (next != mid && next.next != null) {
            // 把指向后面的节点的改为指向前面节点
            current.next = pre;
            // 三个指针都往下走一步
            pre = current;
            current = next;
            next = next.next;
        }
        current.next = pre;
        head.next = null;

        if (size %2 != 0) {
            current = current.next;
        }

        while (mid != null) {
            if (mid.val != current.val) {
                return false;
            }
            mid = mid.next;
            current = current.next;
        }

        return true;
    }

}
