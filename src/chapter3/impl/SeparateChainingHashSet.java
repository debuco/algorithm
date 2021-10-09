package chapter3.impl;

import chapter1.Queue;
import chapter1.impl.queue.SinglyLinkedQueue;
import chapter3.ST;

/**
 * @author bxwang
 * @date 2021/9/30 22:19
 *
 * 数组大小为M
 * 链表长度为L
 * 元素数量为N
 * 1. 散列函数将键转化为数组的一个索引
 *      要求：
 *          a.易于计算
 *          b.能够均匀分布所有的键
 *
 *          一致性
 *          高效性
 *          均匀性
 *
 * 2. 处理碰撞冲突
 *      a. 拉链法
 *      b. 线性探测法
 *
 * 时间和空间上的权衡
 * @param <K>
 * @param <V>
 */
public class SeparateChainingHashSet<K extends Comparable<K>, V> implements ST<K, V> {
    private int size;
    private int capacity;
    /*
        1. 选择较大的数组大小
        2. 动态调整数组的大小 ---> rehash
     */
    private static final int DEFAULT_CAPACITY = 997;
    private SequentialSearchST<K, V>[] st;


    public SeparateChainingHashSet(int capacity) {
        this.capacity = capacity;
        st = new SequentialSearchST[capacity];
        for (int i=0; i < capacity; i++) {
            st[i] = new SequentialSearchST<>();
        }

    }

    public SeparateChainingHashSet() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        st[hash(key)].put(key, value);
        size++;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    @Override
    public V get(K key) {
        return st[hash(key)].get(key);
    }

    @Override
    public void delete(K key) {
        st[hash(key)].delete(key);
        size--;
    }

    @Override
    public boolean contains(K key) {
        return st[hash(key)].contains(key);
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
    public Iterable<K> keys() {
        Queue<K> queue = new SinglyLinkedQueue<>();
        for (int i = 0; i < capacity; i++) {
            getKeys(st[i], queue);
        }
        return queue;
    }

    private void getKeys(SequentialSearchST<K, V> sequentialSearchST, Queue<K> queue){
        if (sequentialSearchST == null) {
            return;
        }
        sequentialSearchST.keys().forEach(k -> queue.enqueue(k));
    }
}
