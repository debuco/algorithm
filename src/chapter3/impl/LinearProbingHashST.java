package chapter3.impl;

import chapter3.ST;

public class LinearProbingHashST<K extends Comparable<K>, V> implements ST<K,V> {
    private int N;
    private int M = 16;
    private K[] keys;
    private V[] values;

    public LinearProbingHashST() {
        keys = (K[]) new Object[M];
        values = (V[]) new Object[M];
    }


    public LinearProbingHashST(int M) {
        this.M = M;
        keys = (K[]) new Object[M];
        values = (V[]) new Object[M];
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (N  >= M/2) {
            reSize(2 * M);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i+1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N ++;
    }

    private void reSize(int capacity) {
        LinearProbingHashST<K, V> t = new LinearProbingHashST<>(capacity);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], values[i]);
            }
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        for (int i = hash(key); keys[i] != null; i = (i+1) % M) {
            if(keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        for (int i = hash(key); keys[i] != null; i=(i+1) % M) {
            if (keys[i].equals(key)) {
                keys[i] = null;
                values[i] = null;
                N--;
                return;
            }
        }
    }

    @Override
    public boolean contains(K key) {
        if (key == null) {
            return false;
        }
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }
}
