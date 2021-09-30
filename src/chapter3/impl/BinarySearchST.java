package chapter3.impl;

import chapter3.SortedST;
import org.omg.CORBA.Object;
import util.CheckUtil;

/**
 * @author bxwang
 * @date 2021/9/30
 * @param <K>
 * @param <V>
 * 平行数组，二分查找，进一步实现-->基于动态数组
 * 核心方法:
 * @see #rank(Comparable)
 * @see #binarySearchCycle(Comparable)
 * @see #binarySearchRecursion(Comparable[], Comparable, int, int)
 */
public class BinarySearchST<K extends Comparable<K>, V> implements SortedST<K, V> {
    private K[] keys;
    private V[] values;
    private int size;

    public BinarySearchST(int capacity) {
        this.keys = (K[]) new Object[capacity];
        this.values = (V[]) new Object[capacity];
    }

    @Override
    public void put(K key, V value) {
        CheckUtil.checkTypeAndCapacity();
        //对删除的支持
        if (value == null) {
            delete(key);
            return;
        }

        int i = binarySearchCycle(key);
        int index = size;
        // 键已存在
        if (i < size && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }

        while (index > i) {
            keys[index] = keys[index - 1];
            values[index] = values[index - 1];
            index--;
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    @Override
    public V get(K key) {
        int index = rank(key);
        if (index < size && key.compareTo(keys[index]) == 0) {
            return values[index];
        }
        return null;
    }

    @Override
    public void delete(K key) {
        int index = rank(key);
        if (index == size || key.compareTo(keys[index]) != 0) {
            return;
        }

        while (index < size) {
            keys[index] = keys[index + 1];
            values[index] = values[index + 1];
            index++;
        }
        size--;
    }

    @Override
    public boolean contains(K key) {
        int index = rank(key);
        return index < size && key.compareTo(keys[index]) == 0;
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
    public int size(K lo, K high) {
        return 0;
    }

    @Override
    public K minKey() {
        CheckUtil.checkTypeAndCapacity();
        return keys[0];
    }

    @Override
    public K maxKey() {
        return keys[size - 1];
    }

    @Override
    public K floor(K key) {
        int index = rank(key);

        if (index == 0) {
            return null;
        }

        if (key.compareTo(keys[index]) == 0) {
            return keys[index];
        } else {
            return keys[index - 1];
        }
    }

    @Override
    public K ceiling(K key) {

        int index = rank(key);
        if (index == size) {
            return null;
        }

        return keys[index];
    }

    @Override
    public int rank(K key) {
        return binarySearchRecursion(keys, key, 0, size - 1);
    }

    /**
     * 二分查找递归实现
     */
    private int binarySearchRecursion(K[] keys, K k, int lo, int high) {
       if (high < lo) {
           return lo;
       }

       int mid = lo + (high - lo)/2;
       int cmp = keys[mid].compareTo(k);

       if ( cmp == 0) {
           return mid;
       } else if (cmp < 0) {
           return binarySearchRecursion(keys, k, mid + 1, high);
       } else {
           return binarySearchRecursion(keys, k, lo, mid - 1);
       }

    }

    /**
     * 二分查找循环实现
     */
    private int binarySearchCycle(K key) {
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    @Override
    public K select(int top) {
        return keys[top];
    }

    @Override
    public void deleteMinKey() {
        delete(keys[0]);
    }

    @Override
    public void deleteMaxKey() {
        delete(keys[size - 1]);
    }

    @Override
    public Iterable<K> keys(K lo, K high) {
        return null;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }
}
