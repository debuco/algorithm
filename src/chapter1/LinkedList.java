package chapter1;

public interface LinkedList<T> {
    T get(int index);
    void addAtHead(T value);
    void addAtTail(T value);
    void addAtIndex(int index, T value);
    void deleteAtIndex(int index);
}
