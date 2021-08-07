package chapter1.impl.stack;

import chapter1.Stack;

import java.util.Iterator;

public class ResizingArrayStack<T> implements Stack<T> {
    private T[] contaner;
    private int size;
    public ResizingArrayStack(int capacity) {
        this.contaner = (T[]) new Object[capacity];
    }

    @Override
    public void push(T t) {
        if (size == contaner.length) {
            resize(2 * contaner.length);
        }

        contaner[size++] = t;
    }

    private void resize(int length) {
        T[] temp = (T[]) new Object[length];
        for (int i=0; i< contaner.length; i++) {
            temp[i] = contaner[i];
        }
        contaner = temp;
    }

    @Override
    public T pop() {
        T val = contaner[--size];
        contaner[size] = null;
        if (size > 0 && size == (contaner.length / 4)) {
            resize(contaner.length/2);
        }
        return val;
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
