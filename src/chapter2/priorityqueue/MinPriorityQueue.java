package chapter2.priorityqueue;

import com.google.common.base.Preconditions;
import util.Exchanger;

/**
 * @author: bangxin.wang
 * @date: 2024/12/21 12:24
 */
public class MinPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T>, Min<T>, Exchanger<T> {
    private T[] container;
    private int index = 0;

    public MinPriorityQueue(int capacity) {
        this.container = (T[]) new Object[capacity + 1];
    }

    @Override
    public T min() {
        if (isEmpty()) {
            return null;
        }
        return container[1];
    }

    @Override
    public T delMin() {
        Preconditions.checkState(isEmpty(), "queue is empty");
        exchange(container, 1, index--);
        // 此处处理游离对象
        container[index + 1] = null;
        sink(container, 1);
        return null;
    }

    private void sink(T[] container, int i) {
        while (i < index) {
            // 找到最小的元素
            int j = 2 * i;
            if (j < index && less(container[j + 1], container[j])) {
                j = j + 1;
            }
            if (!less(container[j], container[i])) {
               break;
            }
            exchange(container, i, j);
            i = j;
        }

    }

    @Override
    public void insert(T val) {
        // 缺少capacity 的校验
        container[++index] = val;
        swim(container, index);
    }

    private void swim(T[] container, int i) {
        // i = 1 的时候不需要比较
        while (i > 1) {
            int j = i / 2;
            if (less(container[i], container[j])) {
                exchange(container, i, j);
                i = j;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return index <= 0;
    }

    @Override
    public int size() {
        return index;
    }

}
