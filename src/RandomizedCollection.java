/**
 * 381.设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 */
public class RandomizedCollection {
    public final int INIT_SIZE = 8;
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
    }

    public Node<Integer, Integer>[] nodes;

    /** 初始化 */
    public RandomizedCollection() {

    }

    /** 插入数据 */
    public boolean insert(int val) {
        return true;
    }

    /** 移除数据 */
    public boolean remove(int val) {
        return false;
    }

    /** 随机获取数据 */
    public int getRandom() {
        return -1;
    }
}

