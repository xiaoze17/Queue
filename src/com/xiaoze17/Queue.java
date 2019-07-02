package com.xiaoze17;

public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E elem);

    E dequeue();

    E getFront();


}
