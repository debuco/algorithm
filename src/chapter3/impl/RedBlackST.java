package chapter3.impl;

import chapter3.SortedST;

/**
 * @author bxwang
 * @date 2021/5/15 9:35
 * @param <K>
 * @param <V>
 */
public class RedBlackST<K extends Comparable<K>, V> implements SortedST<K, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node node;

    private class Node {
        K key;
        V value;
        private Node left, right;
        private boolean color;
        private int size;
        public Node(K key, V value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (value == null) {
            delete(key);
        }

        node = put(node, key, value);
        node.color = BLACK;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            node = new Node(key, value, RED, 1);
        }

        int cmp = key.compareTo(node.key);
        if ( cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private void flipColors(Node node) {
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    private Node rotateRight(Node node) {
        Node r = node.left;
        node.left = r.right;
        r.right = node;
        r.color = node.color;
        node.color = RED;
        r.size = node.size;
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node rotateLeft(Node node) {
        Node r = node.right;
        node.right = r.left;
        r.left = node;
        r.color = node.color;
        node.color = RED;
        r.size = node.size;
        node.size = size(node.left) + size(node.right) + 1;

        return r;
    }



    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        Node result = get(node, key);
        return result == null ? null : result.value;
    }

    private Node get(Node root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp == 0) {
            return root;
        } else if(cmp > 0) {
            return get(root.right, key);
        } else {
            return get(root.left, key);
        }
    }

    @Override
    public void delete(K key) {

    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
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
        return 0;
    }

    @Override
    public K select(int top) {
        return null;
    }

    @Override
    public void deleteMinKey() {

    }

    @Override
    public void deleteMaxKey() {

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
