package chapter1.impl.bag;

import chapter1.Bag;

import java.util.Iterator;

/**
 * @author bxwang
 * @date 2021/9/28
 * @param <T>
 */
public class SinglyLinkedBag<T> implements Bag<T> {
    private int size;
    private Node<T> first;

    @Override
    public void add(T item) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    private class Node<I> {
        private I item;
        private Node<I> next;

        private Node() {
        }

        private Node(I item) {
            this.item = item;
        }

        private Node(I item, Node<I> next) {
            this.item = item;
            this.next = next;
        }
    }
}
