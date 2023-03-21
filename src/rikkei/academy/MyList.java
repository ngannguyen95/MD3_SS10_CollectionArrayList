package rikkei.academy;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    // tao mang moi voi so luong phan tu moi la so phan tu cu cong them
    public void ensureCapacity(int minCapacity) {
        int newSize = elements.length + minCapacity;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + index);
        }
        if (size == elements.length) {
            ensureCapacity(1);
        }
        for (int i = size - 1; i > index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + " ,size: " + index);
        }
        Object temp = elements[index];
        for (int i = index; i < elements.length; i++) {
            elements[i] = elements[i + 1];
        }
        elements = Arrays.copyOf(elements, elements.length - 1);
        return (E) temp;
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                size++;
            }
        }
        return size;
    }

    public E clone() {
        Object[] temp = new Object[size()];
        for (int i = 0; i < size(); i++) {
            temp[i] = elements[i];
        }
        return (E) temp;
    }

    public boolean contain(Object o) {
        for (int i = 0; i < size(); i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    // lấy ra giá trị index trong mảng
    public int indexOf(Object o) {
        int index = 0;
        for (int i = 0; i < size(); i++) {
            if (elements[i].equals(o)) {
                index = i;
            }
        }
        return index;
    }

    public boolean add(E element) {
        if (size == elements.length) {
            ensureCapacity(1);
        }
        elements[size++] = element;
        return true;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("index : " + index + ", size: " + index);
        }
        return (E) elements[index];
    }
    public void clear(){
        elements=Arrays.copyOf(elements,0);
    }

    @Override
    public String toString() {
        return "MyList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
