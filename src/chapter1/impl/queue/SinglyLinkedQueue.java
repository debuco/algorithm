package chapter1.impl.queue;

import chapter1.Queue;

import java.util.Iterator;

/**
 * @author bxwang
 * @date 2021/9/28
 * @param <T>
 */
public class SinglyLinkedQueue<T> implements Queue<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    @Override
    public void enqueue(T item) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T item = first.item;

            Node<T> oldFirst = first;

            first = oldFirst.next;
            if (null == first) {
                last = null;
            }
            size--;

            return item;
        }
        return null;
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
            private Node<T> current = first;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                Node<T> node = current;
                current = current.next;
                return node.item;
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
