/**
 * 移除一个列表倒数第n个节点
 * 1->2->3->4->5, and n = 2. 结果1->2->3->5.
 */
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
        // 计算倒数第n个节点的索引值
        int index = size - n;
        // 最后一个节点
        if (index == 0) {
            h = h.next;
            return h;
        }

        // 找到需要删除节点的前面那个节点
        // 走的步数就是index-1
        while (index - 1 > 0) {
            h = h.next;
            index--;
        }

        // 删除节点
        ListNode tmp;
        tmp = h.next.next;
        h.next = tmp;

        return head;
    }
}

