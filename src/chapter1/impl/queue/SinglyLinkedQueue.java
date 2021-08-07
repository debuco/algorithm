package chapter1.impl.queue;

import chapter1.Queue;

import java.util.Iterator;

public class SinglyLinkedQueue<T> implements Queue<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    @Override
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        Node<T> oldLast = last;
        last = newNode;
        if (size == 0) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (size != 0) {
            Node<T> firstNode = first;
            first = firstNode.next;
            if (null == first) {
                first = last;
            }
            size--;
            return firstNode.item;
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
