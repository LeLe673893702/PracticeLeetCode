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
        LRUCacheByHashMap cache = new LRUCacheByHashMap(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        //234
        cache.put(5, 5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
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
        if (cache.containsKey(key)) {
            Node<Integer, Integer> oldNode = cache.get(key);

            if (oldNode != first) {
                removeOldNode(oldNode);

                // 变成头节点
                oldNode.next = first;
                moveToHead(oldNode);
            }
            return oldNode.value;
        }

        return -1;
    }


    public void put(int key, int value) {
        if (capacity == 0) return;
        // 如果cache满了，移除最后一个，但是如果含有相同的key不用移除，因为key相同旧的会被替换，数量不会变化
        if (capacity == cache.size() && last != null && !cache.containsKey(key)) {
            if (last.pre != null) {
                last.pre.next = null;
            }
            cache.remove(last.key, last);
            last = last.pre;
        }

        // 如果cache为空，直接插入作为头结点
        if (first == null) {
            first = new Node<>(key, value, null, null);
            cache.put(key, first);
            last = first;
            return;
        }

        // 如果没有这个键
        if (!cache.containsKey(key)) {
            Node<Integer, Integer> newNode = new Node<>(key, value, null, first);
            // 插入到头结点
            first.pre = newNode;
            first = newNode;
            cache.put(key, newNode);
            return;
        }

        // 如果包含这个键, 创建新节点并设置为新节点，并且移除旧节点
        if (cache.containsKey(key)) {
            // 旧的节点
            Node<Integer, Integer> oldNode = cache.get(key);

            // 新节点设置为新的头节点
            Node<Integer, Integer> newNode = new Node<>(key, value, null, first);
            moveToHead(newNode);

            // 移除旧节点
            removeOldNode(oldNode);
            cache.put(key, newNode);
        }
    }

    private void moveToHead(Node<Integer, Integer> newNode) {
        first.pre = newNode;
        first = newNode;
    }

    private void removeOldNode(Node<Integer, Integer> oldNode) {
        // 旧节点前一个节点指向旧节点后一个节点
        if (oldNode.pre != null) {
            oldNode.pre.next = oldNode.next;
        }

        // 旧节点后一个节点指向旧节点前一个节点
        if (oldNode.next != null) {
            oldNode.next.pre = oldNode.pre;
        } else {
            last = oldNode.pre;
        }
    }
}
