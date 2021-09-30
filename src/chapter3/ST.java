package chapter3;

/**
 * @author bxwang
 * @date 2021/9/29 21:50
 * @param <K>
 * @param <V>
 */
public interface ST<K, V> {
    void put(K key, V value);
    V get(K key);
    void delete(K key);
    boolean contains(K key);
    boolean isEmpty();
    int size();
    Iterable<K> keys();
}
