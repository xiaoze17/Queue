package com.xiaoze17;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length-1;
    }
    @Override
    public int getSize() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E elem) {
        if((tail+1)%data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = elem;
        tail = (tail+1)%data.length;
        size++;
    }

    private void resize(int newCapacity) {

        E[] newData = (E[])new Object[newCapacity+1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+front)%data.length];
        }
    /*    if(tail > front){
            for (int i = front; i < tail; i++) {
                newData[i] = data[i];
            }
        }else{
            for(int i = front; i<getCapacity();i++){
                newData[i] = data[i];
            }
            for (int j = 0; j < tail; j++) {
                newData[j + getCapacity() - 1] = data[j];
            }
        }*/
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("LoopQueue is empty, dequeue nmn?");
        }
        E tmp = data[front];
        data[front] = null;
        front = (front+1) %data.length;
        size--;
        if (size == getCapacity() / 4 && size >= 2) {
            resize(getCapacity()/2);
        }
        return tmp;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LoopQueue : [");
        for (int i = 0; i < size; i++) {
            res.append(data[(i+front)%data.length]+" ");
        }
        /*if(tail > front){
            for (int i = front; i < tail; i++) {
                res.append(data[i]+" ");
            }
        }else if(tail < front){
            for (int i = front; i < data.length; i++) {
                res.append(data[i] + " ");
            }
            for (int i = 0; i < tail; i++) {
                res.append(data[i] + " ");
            }
        }
        else{
            res.append("kong");
        }*/
        res.append("]");
        return res.toString();

    }

    public static void main(String[] args) {
        LoopQueue<Integer> lqueue = new LoopQueue<>(5);
        System.out.println(lqueue.getCapacity());
        for (int i = 0; i < 9; i++) {
            lqueue.enqueue(i);
        }
        System.out.println(lqueue);
        System.out.println(lqueue.getCapacity());

        System.out.println(lqueue.dequeue());
        System.out.println(lqueue.getFront());

        System.out.println(lqueue.dequeue());
        System.out.println(lqueue.getFront());

        System.out.println(lqueue.dequeue());
        System.out.println(lqueue.getFront());

        System.out.println(lqueue.dequeue());
        /*
        lqueue.enqueue(5);

        System.out.println(lqueue);
        lqueue.enqueue(88);
        System.out.println(lqueue.getFront());
        */
    }

}

