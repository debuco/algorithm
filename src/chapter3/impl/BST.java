package chapter3.impl;

import chapter1.Queue;
import chapter1.impl.queue.SinglyLinkedQueue;
import chapter3.SortedST;
import com.sun.istack.internal.NotNull;
import util.CheckUtil;

import java.util.NoSuchElementException;

/**
 * @author bxwang
 * @date 2021/9/30
 * @param <K>
 * @param <V>
 * 二叉查找树：
 *  ·每个节点都有一个{@link Comparable}的键
 *  ·每个节点的键都大于左子节点的任意键，小于右子节点的任意键
 *
 *  递归
 */
public class BST<K extends Comparable<K>, V> implements SortedST<K, V> {

    private class Node<K1 extends Comparable<K1>, V1> {
        private K1 key;
        private V1 value;
        private Node<K1, V1> left, right;
        private int N;
        private Node(K1 key, V1 value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    private Node<K, V> node;

    @Override
    public void put(K key, V value) {
        CheckUtil.checkTypeAndCapacity();

        node = put(node, key, value);
    }

    private Node<K, V> put(Node<K, V> root, K key, V value) {
        if (root == null) {
            return new Node<>(key, value, 1);
        }

        int cmp = root.key.compareTo(key);
        if (cmp == 0) {
            root.value = value;
            return root;
        } else if (cmp < 0) {
            root.right = put(root.right, key, value);
        } else {
            root.left = put(root.left, key, value);
        }
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }


    @Override
    public V get(K key) {
        CheckUtil.checkTypeAndCapacity();

        Node<K, V> result = getNode(node, key);
        return result==null ? null : result.value;
    }

    private Node<K,V> getNode(Node<K,V> root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = root.key.compareTo(key);
        if (cmp == 0) {
            return root;
        } else if (cmp < 0) {
            return getNode(root.right, key);
        } else {
            return getNode(root.left, key);
        }
    }

    @Override
    public void delete(K key) {
        CheckUtil.checkTypeAndCapacity();
        node = delete(node, key);
    }


    private Node<K, V> delete(Node<K, V> root, K key) {
       if (root == null) {
           return null;
       }
       int cmp = root.key.compareTo(key);
       if (cmp == 0) {
           if (root.left == null) {
               return root.right;
           }

           if (root.right == null) {
               return root.left;
           }
           // 保存临时二叉树
           Node<K, V> temp = root;
           // 将root指向临时二叉树的右子节点中的最小节点
           root = min(temp.right);
           // root的左子节点指向临时二叉树的左子节点
           root.left = temp.left;
           // root的右子节点指向删除了最小节点的右子节点
           root.right = deleteMin(temp.right);

       } else if (cmp < 0) {
           root.right = delete(root.right, key);
       } else {
           root.left = delete(root.left, key);
       }
       root.N = size(root.left) + size(root.right) + 1;
       return root;
    }

    private Node<K, V> deleteMin(Node<K, V> root) {
        if (root == null) {
            return null;
        }

        if (root.left == null) {
            return root.right;
        }

        root = deleteMin(root.left);
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    private Node<K, V> deleteMax(Node<K, V> root) {
        if (root.right != null) {
            root.right = deleteMax(root.right);
        } else {
            return root.left;
        }

        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }


    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return node == null;
    }

    @Override
    public int size() {
        return size(node);
    }

    private int size(Node<K,V> node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    @Override
    public int size(K lo, K high) {
        return 0;
    }

    @Override
    public K minKey() {
        if (isEmpty()) {
            return null;
        }
        return min(node).key;
    }

    private Node<K, V> min(@NotNull Node<K,V> root) {
        if (root.left!=null) {
            return min(root.left);
        } else {
            return root;
        }
    }

    @Override
    public K maxKey() {
        if (isEmpty()) {
            return null;
        }
        return max(node).key;
    }

    private Node<K, V> max(Node<K,V> node) {
        if (node.right == null) {
            return node;
        } else {
            return max(node);
        }
    }

    @Override
    public K floor(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<K, V> result = floor(node, key);

        return result == null ? null : result.key;
    }

    private Node<K, V> floor(Node<K, V> root, K key) {
        if (root == null) {
            return null;
        }

        int cmp = root.key.compareTo(key);
        if (cmp == 0) {
            return root;
        } else if(cmp < 0) {
            Node t = floor(root.right, key);
            if (t == null) {
                return root;
            } else {
                return t;
            }
        } else {
            return floor(root.left, key);
        }
    }

    @Override
    public K ceiling(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<K, V> result = ceiling(node, key);

        if (result == null) {
            throw new NoSuchElementException();
        }
        return result.key;
    }

    private Node<K,V> ceiling(Node<K, V> root, K key) {
        if (root == null) {
            return null;
        }
        /*
            1. 相等，返回key
            2. key > 当前节点的key， 去右半边接着找比key大的节点
            3. key < 当前节点的key，去左半边找比key小的节点
         */
        int cmp = key.compareTo(root.key);
        if (cmp == 0) {
            return root;
        } else if (cmp > 0) {
            return ceiling(root.right, key);
        }

        Node<K, V> temp = ceiling(node.left, key) ;
        if (temp == null) {
            return node;
        }
        return temp;
    }

    @Override
    public int rank(K key) {
        if(key == null) {
            throw new IllegalArgumentException();
        }
        return rank(node, key);
    }

    private int rank(Node<K,V> root, K key) {
        if (root == null) {
            return 0;
        }

        int cmp = key.compareTo(root.key);
        if (cmp == 0) {
            return size(root.left);
        } else if (cmp < 0) {
            return rank(root.left, key);
        } else {
            return 1 + size(root.left) + rank(root.right, key);
        }

    }

    @Override
    public K select(int top) {
        if (top < 0 || top >= size()) {
            throw new IllegalArgumentException();
        }
        return select(node, top);
    }

    private K select(Node<K, V> root, int k) {
        if (root == null) {
            return null;
        }

        int leftSize = size(root.left);
        if (leftSize == k) {
            return root.key;
        } else if (leftSize > k) {
            return select(root.left, k);
        } else {
            return select(root.right, k - leftSize - 1);
        }
    }


    @Override
    public void deleteMinKey() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        node = deleteMin(node);
    }

    @Override
    public void deleteMaxKey() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        node = deleteMax(node);
    }

    @Override
    public Iterable<K> keys(K lo, K high) {
        CheckUtil.checkTypeAndCapacity();
        Queue<K> queue = new SinglyLinkedQueue<>();
        keys(node, queue, lo, high);
        return queue;
    }

    private void keys(Node<K, V> root, Queue<K> queue, K lo, K high) {
        if (root == null) {
            return;
        }

        int cmpLo = lo.compareTo(root.key);
        int cmpHigh = high.compareTo(root.key);

        if (cmpLo <= 0 && cmpHigh >= 0) {
            queue.enqueue(root.key);
        } else if (cmpLo>0) {
            keys(root.left, queue, lo, high);
        } else {
            keys(root.right, queue, lo, high);
        }


    }

    @Override
    public Iterable<K> keys() {
        return keys(min(node).key, max(node).key);
    }
}
