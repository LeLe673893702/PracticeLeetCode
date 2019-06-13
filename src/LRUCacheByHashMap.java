import java.util.HashMap;

/**
 * 146. LRU Cache 最近最久未使用
 * 设计一个LRU表，LRU思想如果有元素被使用则会被移动头部，如
 * 果被元素访问则被移动到头部，
 * 后插入的在前面，先插入的在后面
 * 如果容量满了则移除最后一个也就是最久没被访问的
 */
public class LRUCacheByHashMap {
    public static void main(String[] args) {
        LRUCacheByHashMap cache = new LRUCacheByHashMap(1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        //234
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

    private int capacity ;
    private Node<Integer, Integer> first;
    private Node<Integer, Integer> last;
    private HashMap<Integer, Node<Integer, Integer>> cache;

    static class Node<K, V> {
        K key;
        Node<K, V> next;
        V value;
        Node<K, V> pre;

        public Node(K key, V value, Node<K, V> pre, Node<K, V> next) {
            this.key = key;
            this.next = next;
            this.value = value;
            this.pre = pre;
        }
    }


    public LRUCacheByHashMap(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node<Integer, Integer> findNode = cache.get(key);

        if (findNode != null) {
            moveToHead(findNode);
            return findNode.value;
        }

        return -1;
    }


    public void put(int key, int value) {
        if (capacity == 0) return;
        Node<Integer, Integer> findNode = cache.get(key);

        // 如果键存在
        if (findNode != null) {
            findNode.value = value;
            moveToHead(findNode);
            return;
        }

        Node<Integer, Integer> newNode = new Node<>(key, value, null, first);

        // 如果cache满了，移除最后一个
        if (capacity == cache.size()) {
            removeLast();
            // 插入到头结点
            addToHead(newNode);
            cache.put(key, newNode);
            return;
        }

        // 插入到头结点
        addToHead(newNode);
        cache.put(key, newNode);
    }

    private void addToHead(Node<Integer, Integer> node) {
        if (first == null) {
            last = first = node;
            return;
        }
        first.pre = node;
        node.next = first;
        first = node;
        node.pre = null;
    }

    private void removeNode(Node<Integer, Integer> node) {

        // 节点前一个节点指向旧节点后一个节点
        if (node.pre != null) {
            node.pre.next = node.next;
        }

        // 节点后一个节点指向旧节点前一个节点
        if (node.next != null) {
            node.next.pre = node.pre;
        }

        if (last == node) {
            last = last.pre;
        }

    }

    private void moveToHead(Node<Integer, Integer> node) {
        if (node == first) {
            return;
        }
        removeNode(node);
        addToHead(node);
    }

    private void removeLast() {
        cache.remove(last.key, last);
        removeNode(last);
        // 如果只有一个节点，移除完变为空链表
        if (last == null) {
            first = null;
        }
    }
}
