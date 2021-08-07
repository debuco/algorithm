package chapter3.impl;

import chapter1.Queue;
import chapter1.impl.queue.SinglyLinkedQueue;
import chapter3.ST;

public class SequentialSearchST<K extends Comparable<K>, V> implements ST<K, V> {

    private class Node{
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

    private Node head ;

    private int size;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        if (value == null) {
            delete(key);
            return;
        }
        Node tempNode = head;
        for (; tempNode != null; tempNode = tempNode.next) {
            if (tempNode.key.equals(key)) {
                tempNode.value = value;
                return;
            }
        }
        head = new Node(key, value, head);
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        V result = null;
        for (Node tempNode = head; tempNode != null; tempNode = tempNode.next) {
            if (tempNode.key.equals(key)) {
                result = tempNode.value;
                break;
            }
        }
        return result;
    }

    @Override
    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        head = delete(head, key);
    }
    private Node delete(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            size--;
            return node.next;
        }

        node.next = delete(node.next, key);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return contains(head, key);
    }

    private boolean contains(Node head, K key) {
        if (head == null) {
            return false;
        }

        if (head.key.equals(key)) {
            return true;
        }

        return contains(head.next, key);
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
        keys(head, queue);
        return queue;
    }

    private void keys(Node head, Queue<K> queue) {
        if (head == null) {
            return;
        }
        queue.enqueue(head.key);
        keys(head.next, queue);
    }
}
