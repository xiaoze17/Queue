package com.xiaoze17;

public class LinkedListQueue<E> implements Queue<E>{

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = new Node();
        tail = head;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public void enqueue(E e) {
        Node newNode = new Node(e, tail.next);
        tail.next = newNode;
        size++;
        tail = newNode;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        Node delNode = head.next;
        head.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        return head.next.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node temp = head.next;
        res.append("LinkedListQueue front: [");
        for (int i = 0; i < size; i++) {
            res.append(temp.e+"->");
            temp = temp.next;
        }
        res.append("null]");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 1; i++) {
            linkedListQueue.enqueue(i);
        }
        System.out.println(linkedListQueue);
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);
    }
}
