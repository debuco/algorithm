package chapter3;

public interface SortedST<K extends Comparable<K>, V> {
    void put(K key, V value);
    V get(K key);
    void delete(K key);
    boolean contains(K key);
    boolean isEmpty();
    int size();
    int size(K lo, K high);
    K minKey();
    K maxKey();
    /**
     * 小于等于key的最大键
     */
    K floor(K key);
    /**
     * 大于等于k的最小键
     */
    K ceiling(K key);
    /**
     * 小于key的键的数量
     */
    int rank(K key);
    /**
     * 排名为k的键
     */
    K select(int top);
    void deleteMinKey();
    void deleteMaxKey();
    Iterable<K> keys(K lo, K high);
    Iterable<K> keys();
}
