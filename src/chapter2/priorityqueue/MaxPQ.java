package chapter2.priorityqueue;

import util.CheckUtil;

/**
 * @author bxwang
 * @date 2021/9/28 22:10
 * @param <T>
 * 大顶堆
 *
 */
public class MaxPQ<T extends Comparable<T>> implements MaxPriorityQueue<T> {
    private T[] container;
    private int index = 0;
    public MaxPQ(int capacity) {
        this.container = (T[]) new Object[capacity + 1];
    }

    @Override
    public T max() {
        return container[1];
    }

    @Override
    public T delMax() {
        T item = container[1];
        exch(container, 1, index--);
        // 当心游离对象
        container[index + 1] = null;
        sink(1);
        return item;
    }

    @Override
    public void insert(T val) {
        CheckUtil.checkTypeAndCapacity();
        container[++index] = val;
        swim(index);
    }


    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public int size() {
        return index;
    }

    /**
     * 二叉堆的上浮有序化
     * @param i
     */
    private void swim(int i) {
        while (i > 1 && less(container[i/2], container[i])) {
            exch(container, i, i/2);
            i = i/2;
        }
    }

    /**
     * 二叉堆的下沉有序化
     * @param i
     */
    private void sink(int i) {
        while (i <= index) {
            int j = 2 * i;
            if (j < index && less(container[j], container[j+1])) {
                j++;
            }

            if (!less(container[i], container[j])) {
                break;
            }

            exch(container, i, j);
            i = j;
        }
    }

    private boolean less(T v1, T v2) {
        return v1.compareTo(v2) < 0;
    }

    private void exch(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
