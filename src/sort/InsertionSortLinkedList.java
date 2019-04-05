package sort;

public class InsertionSortLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-1);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(0);
        listNode.next.next.next.next.next = new ListNode(1);

        ListNode head = insertionSortList(listNode);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null ) return head;
        ListNode  tmp;
        int k, z;
        for (ListNode start = head; start.next != null; start = start.next) {
            tmp = start.next;
            k = tmp.val;
            ListNode end;
            for (end = head; end != start.next; end = end.next) {
                if (tmp.val < end.val) {
                    z = end.val;
                    end.val = k;
                    k = z;
                }
            }
            end.val = k;
        }
        return head;
    }
}
