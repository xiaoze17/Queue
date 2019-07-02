package com.xiaoze17;

public class Array<T> {

    private T[] data;
    private int size;//数组中有效元素的个数

    /**
     * 构造函数，传入capacity构造Array
     * @param the maxsize of data:capacity
     */
    public Array(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }

    /**
     * 无参数构造函数，默认数组容量capacity是10
     */
    public Array(){
        this(10);
    }
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(T elem){
        insert(elem, size);
    }

    public void addFirst(T elem) {
        insert(elem, 0);
    }

    /*
    在pos位置插入一个新元素elem
     */
    public void insert(T elem, int pos) {
        if(size==data.length){
            //throw new IllegalArgumentException("Array is full");
            resize(2 * data.length);
        }
        if (pos < 0 || pos > size) {
            throw new IllegalArgumentException("position is illegal");
        }

        for (int i = size-1; i >= pos; i--) {
            data[i+1] = data[i];
        }
        data[pos] = elem;
        size++;

    }

    public T delete(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("position is illegal");
        }
        T temp = data[pos];
        for (int i = pos+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;//假如存的是引用，指的最后一个对象没人管了，不能启用垃圾回收机制
        if (size == data.length / 4 && data.length/2 != 0) {
            resize(data.length/2);
        }
        return temp;
    }

    public boolean deleteElem(T elem) {
        int index = find(elem);
        if (index != -1) {
            delete(index);
            return true;
        }else{
            return false;
        }
    }

    public T deleteFirst() {
        return delete(0);
    }

    public T deleteLast() {
        return delete(size - 1);
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index!");
        }
        return data[index];
    }

    public void set(int index, T elem) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index!");
        }
        data[index] = elem;
    }

    public boolean contains(T elem) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    public int find(T elem) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public void resize(int newCapacity) {
        T[] newData = (T[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    //@Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d, capacity = %d\n",size,data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
    public void show() {
        for (int i = 0; i < size; i++) {
            //System.out.print(data[i] /+" ");
            if(i!=size-1){
                System.out.print(data[i]+" ");
            }else{
                System.out.print(data[i]);
            }

        }
    }

}
