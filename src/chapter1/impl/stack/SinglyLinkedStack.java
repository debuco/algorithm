package chapter1.impl.stack;

import chapter1.Stack;
import util.CheckUtil;

import java.util.Iterator;

/**
 * @author bxwang
 * @date 2021/9/28
 * @param <T>
 */
public class SinglyLinkedStack<T> implements Stack<T> {

    private int size;
    private Node<T> first;

    @Override
    public void push(T t) {
        CheckUtil.checkType();
        Node<T> oldFirst = first;

        first = new Node<>();
        first.item = t;
        first.next = oldFirst;
        size ++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T value = first.item;
        first = first.next;
        size--;

        return value;
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
