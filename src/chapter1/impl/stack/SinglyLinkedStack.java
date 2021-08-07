package chapter1.impl.stack;

import chapter1.Stack;

import java.util.Iterator;

public class SinglyLinkedStack<T> implements Stack<T> {

    private int size;
    private Node<T> first;

    @Override
    public void push(T t) {
        Node<T> node = new Node<>(t);
        Node<T> oldFirst = first;
        first = node;
        first.next = oldFirst;
        size++;
    }

    @Override
    public T pop() {
        Node<T> firstNode = first;
        if (first != null) {
            first = first.next;
            size--;
        }
        return firstNode.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
