package chapter1;

public interface Bag<T> extends Iterable<T> {
    void add(T item);
    boolean isEmpty();
    int size();
}
