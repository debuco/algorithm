package chapter1.impl.stack;

import chapter1.Stack;
import org.omg.CORBA.Object;
import util.CheckUtil;

import java.util.Iterator;

/**
 * @author bxwang
 * @date 2021/9/28 16:51
 * @param <T>
 */
public class ResizingArrayStack<T> implements Stack<T> {
    private T[] container;
    private int size;
    public ResizingArrayStack(int capacity) {
        this.container = (T[]) new Object[capacity];
    }


    @Override
    public void push(T item) {
        CheckUtil.checkTypeAndCapacity();

        // 占满扩容， 2倍扩容，可以考虑最大的扩容是多少，java集合类大多数的扩容都是Integer.MAX，不能扩容时要怎么做。
        if (size == container.length) {
            resize(2 * container.length);
        }

        container[size++] = item;
    }

    private void resize(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        System.arraycopy(container, 0, temp, 0, size);
        container = temp;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T value = container[--size];
        // 注意对象游离，防止对象不能被垃圾回收器及时回收
        container[size] = null;
        if (size > 0 && size == container.length) {
            resize(container.length / 2);
        }
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
        return new ReverseArrayIterator<>();
    }

    private class ReverseArrayIterator<I> implements Iterator<I> {
        private int index = size - 1;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public I next() {
            return (I) container[index--];
        }
    }

}
