/**
 * 设置一个LinkedList
 */
public class DesignLinkedList {
    private static class Node {
        int val;
        Node next;
        Node prev;

        Node(Node prev, Integer element, Node next) {
            this.val = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node first = null;
    private Node last = null;

    public DesignLinkedList() {

    }

    public int get(int index) {
        Node tmp = first;
        if (tmp == null) return -1;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
            if (tmp == null) {
                return -1;
            }
        }

        return tmp.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(null, val, first);
        if (first == null) {
            last = first = newNode;
        } else {
            first.prev = newNode;
            first = newNode;
        }
    }


    public void addAtTail(int val) {
        Node newNode = new Node(last, val, null);
        if (last == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    public void addAtIndex(int index, int val) {
        Node tmp = first;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (tmp == null) return;
        // 找到删除的前一个指针
        for (int i = 0; i < index-1; i++) {
            tmp = tmp.next;
            if (tmp == null) {
                return;
            }
        }
        Node newNode = new Node(tmp, val, tmp.next);
        if (tmp == last) {
            addAtTail(val);
            return;
        }
        tmp.next.prev = newNode;
        tmp.next = newNode;
    }

    public void deleteAtIndex(int index) {
        Node tmp = first;
        if (tmp == null) return;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
            if (tmp == null) {
                return;
            }
        }

        if (tmp == first) {
            first = first.next;
            if (first != null) {
                first.prev = null;
                return;
            }
        }

        if (tmp == last) {
            last = last.prev;
            if (last != null) {
                last.next = null;
                return;
            }
        }

        tmp.next.prev = tmp.prev;
        tmp.prev.next = tmp.next;
    }
}
