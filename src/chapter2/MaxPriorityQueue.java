package chapter2;

public interface MaxPriorityQueue<T extends  Comparable<T>> {
    T max();
    T delMax();
    void insert(T val);
    boolean isEmpty();
    int size();
}
