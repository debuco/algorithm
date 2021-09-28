package chapter1.impl.stack;

import chapter1.Stack;
import util.CheckUtil;

import java.util.Iterator;

/**
 * @author bxwang
 * @date 2021/9/28
 * @param <T>
 */
public class FixedCapacityStack<T> implements Stack<T> {

    /**
     *  存储元素的容器
     */
    private T[] container;
    /**
     * 容器中元素的数量
     */
    private int size;

    public FixedCapacityStack(int capacity) {
        container = (T[]) new Object[capacity];
    }

    @Override
    public void push(T t) {
        CheckUtil.checkTypeAndCapacity();

        container[size++] = t;
    }

    @Override
    public T pop() {
        // can throw exception or just return null
        if (isEmpty()) {
            return null;
        }

        T value = container[--size];
        // 注意对象游离，不能及时被垃圾回收器回收
        container[size] = null;
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
