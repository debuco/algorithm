package chapter3.impl;

import chapter3.SortedST;
import org.omg.CORBA.Object;

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
        int i = rank2(key);
        int index = size;
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
        return null;
    }

    @Override
    public K maxKey() {
        return null;
    }

    @Override
    public K floor(K key) {

        return null;
    }

    @Override
    public K ceiling(K key) {
        return null;
    }

    @Override
    public int rank(K key) {
        return binarySearch(keys, key, 0, keys.length - 1);
    }

    private int binarySearch(K[] keys, K k, int lo, int high) {
        if (high < lo) {
            return lo;
        }
        int mid = lo + (high - lo) / 2;
        int cmp = k.compareTo(keys[mid]);
        if (cmp == 0) {
            return mid;
        } else if (cmp < 0) {
            return binarySearch(keys, k, lo, mid - 1);
        } else {
            return binarySearch(keys, k, mid + 1, high);
        }
    }

    private int rank2(K key) {
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
