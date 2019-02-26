public class RemoveNthNodeFromEndofList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ListNode head = removeNthFromEnd(listNode, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode h = head;
        while (h != null) {
            size++;
            h = h.next;
        }

        h = head;
        int a = size - n;
        if (a == 0) {
            h = h.next;
            return h;
        }

        // 找到需要删除节点的前面那个节点
        // 走的步数就是a-1
        while (a > 1) {
            h = h.next;
            a--;
        }

        ListNode tmp;
        tmp = h.next.next;
        h.next = tmp;

        return head;
    }
}

