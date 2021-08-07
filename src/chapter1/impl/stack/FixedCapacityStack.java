package chapter1.impl.stack;

import chapter1.Stack;

import java.util.Iterator;

public class FixedCapacityStack<T> implements Stack<T> {

    private T[] contaner;
    private int size = 0;
    public FixedCapacityStack(int capacity) {
        contaner = (T[]) new Object[capacity];
    }


    @Override
    public void push(T t) {
        if (size >= contaner.length){
            throw new RuntimeException();
        }

        contaner[size++] = t;
    }

    @Override
    public T pop() {
        if (size <= 0) {
            throw new RuntimeException();
        }

        return contaner[--size];
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
            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public T next() {
                return contaner[--size];
            }
        };
    }
}
