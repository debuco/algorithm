package chapter1;

/**
 * @author bxwang
 * @date 2021/9/28
 */
public interface Bag<T> extends Iterable<T> {
    void add(T item);
    boolean isEmpty();
    int size();
}
