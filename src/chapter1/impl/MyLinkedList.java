package chapter1.impl;

class MyLinkedList {

    private class Node {
        private int val;
        private Node next;
        private Node(int val) {
            this.val = val;
        }
    }

    private Node head = new Node(0);
    private Node tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index > size - 1 || index < 0) {
            return -1;
        }
        int i = 0;
        Node temp = head.next;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        Node oldHead = head.next;

        head.next = node;
        node.next = oldHead;

        if (size == 0) {
            tail = node;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        Node oldTail = tail;

        if (size == 0) {
            head.next = node;
            tail = node;
            size ++;
            return;
        }

        tail = node;
        oldTail.next = tail;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
            return;
        } else if (index > size) {
            return;
        } else if (index < 0) {
            addAtHead(val);
            return;
        } else {
            Node node = new Node(val);
            int i = 0;
            Node temp = head;
            while (i < index) {
                temp = temp.next;
                i++;
            }
            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if ( index >= 0 && index < size) {
            int i = 0;
            Node temp = head;
            while (i < index) {
                temp = temp.next;
                i++;
            }

            temp.next = temp.next.next ;
            if (temp.next == null) {
                tail = temp.next;
            }

            size--;

        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(0);
        linkedList.addAtIndex(1, 4);
        linkedList.addAtTail(8);
        linkedList.addAtHead(5);
        linkedList.addAtIndex(4, 3);
        linkedList.addAtTail(0);
        linkedList.addAtTail(5);
        linkedList.addAtIndex(6,3);
        linkedList.deleteAtIndex(7);
        linkedList.deleteAtIndex(5);
        linkedList.addAtTail(4);
    }
}
