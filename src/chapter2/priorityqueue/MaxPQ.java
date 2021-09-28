package chapter2.priorityqueue;

/**
 * @author bxwang
 * @date 2021/9/28 22:10
 * @param <T>
 */
public class MaxPQ<T extends Comparable<T>> implements MaxPriorityQueue<T> {
    private T[] contaner;
    private int index = 0;
    public MaxPQ(int capacity) {
        this.contaner = (T[]) new Object[capacity + 1];
    }

    @Override
    public T max() {
        return contaner[1];
    }

    @Override
    public T delMax() {
        T item = contaner[1];
        exch(contaner, 1, index--);
        contaner[index + 1] = null;
        sink(1);
        return item;
    }

    @Override
    public void insert(T val) {
        contaner[++index] = val;
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
        while (i > 1 && less(contaner[i/2], contaner[i])) {
            exch(contaner, i/2, i);
            i = i/2;
        }
    }

    /**
     * 二叉堆的下沉有序化
     * @param i
     */
    private void sink(int i) {
        while (2 * i <= index) {
            int j = 2*i;
            if (j < index && less(contaner[j], contaner[j + 1])) {
                j++;
            }
            if (!less(contaner[i], contaner[j])) {
                break;
            }
            exch(contaner, i, j);
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
