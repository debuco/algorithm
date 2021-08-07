package chapter2.impl;

import chapter2.MaxPriorityQueue;

public class MaxPQ<T extends Comparable<T>> implements MaxPriorityQueue<T> {
    private T[] contaner;
    private int index = 0;
    public MaxPQ(int capacity) {
        this.contaner = (T[]) new Object[capacity];
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

    private void swim(int i) {
        while (i > 1 && less(contaner[i/2], contaner[i])) {
            exch(contaner, i/2, i);
            i = i/2;
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
