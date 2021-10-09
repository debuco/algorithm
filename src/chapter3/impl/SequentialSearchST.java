package chapter3.impl;

import chapter1.Queue;
import chapter1.impl.queue.SinglyLinkedQueue;
import chapter3.ST;
import com.sun.istack.internal.Nullable;
import util.CheckUtil;

/**
 * @author bxwang
 * @date 2021/9/30
 * @param <K>
 * @param <V>
 */
public class SequentialSearchST<K extends Comparable<K>, V> implements ST<K, V> {
    private class Node {
        private K key;
        private V value;
        private Node next;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;

    private int size;

    @Override
    public void put(K key, V value) {
        //元素判空
        CheckUtil.checkTypeAndCapacity();

        //延时删除
        if (value == null) {
            delete(key);
            return;
        }

        //判断该键对应的node是否已经存在
        Node exist = getNode(head, key);
        //存在相同键的节点
        if (exist != null) {
            exist.value = value;
        } else {
            Node oldFirst = head;
            head = new Node(key, value);
            head.next = oldFirst;
            size ++;
        }
    }

    @Nullable
    private Node getNode(Node head, K key) {
        if (head == null) {
            return null;
        }
        if (head.key.compareTo(key) == 0) {
            return head;
        }

        return getNode(head.next, key);
    }

    @Override
    public V get(K key) {
        CheckUtil.checkTypeAndCapacity();

        Node exists = getNode(head, key);
        return null == exists ? null : exists.value;
    }

    @Override
    public void delete(K key) {
        head = deleteKey(head, key);
    }

    private Node deleteKey(Node head, K key) {
        if (head == null) {
            return null;
        }
        if (head.key.compareTo(key) == 0) {
            size--;
            return head.next;
        }

        head.next = deleteKey(head.next, key);

        return head;
    }

    @Override
    public boolean contains(K key) {
        return getNode(head, key) != null;
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
        for (Node node=head; node!=null; node = node.next) {
            queue.enqueue(node.key);
        }
        return queue;
    }

}
