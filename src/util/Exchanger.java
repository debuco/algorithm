package util;

/**
 * @author: bangxin.wang
 * @date: 2024/12/21 12:29
 */
public interface Exchanger<T extends Comparable<T>> {

    default boolean less(T v1, T v2) {
        return v1.compareTo(v2) < 0;
    }

    default void exchange(T[] container, int i, int j) {
        T temp = container[i];
        container[i] = container[j];
        container[j] = temp;
    }
}
