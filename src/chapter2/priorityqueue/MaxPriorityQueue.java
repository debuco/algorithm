package chapter2.priorityqueue;

/**
 * @author bxwang
 * @date 2021/9/28 21:57
 * 思考：如何高效的实现优先队列？
 *
 * @param <T>
 */
public interface MaxPriorityQueue<T extends  Comparable<T>> {
    T max();
    T delMax();
    void insert(T val);
    boolean isEmpty();
    int size();
}
