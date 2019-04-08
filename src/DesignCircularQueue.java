/**
 * 用数组创建一个循环队列，
 */
public class DesignCircularQueue {
    private int[] queue;
    private int size = 0;
    private int front = 0, rear = -1;

    public static void main(String[] args) {
        DesignCircularQueue circularQueue = new DesignCircularQueue(5); // 设置长度为3

        System.out.println(circularQueue.enQueue(4));  // 返回true
        System.out.println(circularQueue.enQueue(4));  // 返回true
        System.out.println(circularQueue.enQueue(4));  // 返回true
        System.out.println(circularQueue.enQueue(4));  // 返回true
//        System.out.println(circularQueue.isFull());
//        System.out.println(circularQueue.deQueue());  // 返回true
//        System.out.println(circularQueue.deQueue());  // 返回true
//        System.out.println(circularQueue.deQueue());  // 返回true
//        System.out.println(circularQueue.deQueue());  // 返回true
//        System.out.println(circularQueue.deQueue());  // 返回true
//        System.out.println(circularQueue.enQueue(4));  // 返回true
//        System.out.println(circularQueue.deQueue());  // 返回true
//        System.out.println(circularQueue.isEmpty());  // 返回true

        System.out.println(circularQueue.Rear());  // 返回true

//        System.out.println(circularQueue.enQueue(3));  // 返回true

//        System.out.println(circularQueue.enQueue(4));  // 返回false,队列已满
//        System.out.println(circularQueue.Rear());  // 返回3
//        System.out.println(circularQueue.isFull());  // 返回true
        System.out.println(circularQueue.deQueue());  // 返回true
        System.out.println(circularQueue.enQueue(4));  // 返回true
//
        System.out.println(circularQueue.Rear());  // 返回4
    }

    public DesignCircularQueue(int k) {
        queue = new int[k];
    }

    /**
     * 入队
     */
    public boolean enQueue(int value) {
        if (!isFull()) {
            // 尾部后移，插入新节点
            rear = (rear+1) % queue.length;
            queue[rear] = value;
            size++;
            return true;
        }
        return false;
    }

    /**
     * 出队
     */
    public boolean deQueue() {
        if (!isEmpty()) {
            queue[front] = -1 ;
            // 头部后移
            front = (front+1) % queue.length;
            size--;
            return true;
        }
        return false;
    }

    public int Front() {
        if (size == 0) return -1;
        return queue[front];
    }

    public int Rear() {
        if (size == 0) return -1;
        return queue[(rear) % queue.length] ;
    }

    public boolean isEmpty() {
        System.out.println(rear + "---" + front);
        return size == 0;
    }

    public boolean isFull() {
        System.out.println(rear + "---" + front);
        return size == queue.length;
    }
}
