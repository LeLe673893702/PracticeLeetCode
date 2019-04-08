import java.util.HashMap;
import java.util.Stack;

/**
 * 链表是否存在环，3又指向了1
 * 1 -> 2 -> 3
 *  \←←←←←←←←/
 *
 * 思路快慢指针，一个走1步，一个走两步，如果是个环，走两步的迟早赶上走1步的
 */
public class LinkedListCycle {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = head.next.next;

        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        int i= 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
            i++;
        }
        System.out.print(i);
        return false;
    }
}
