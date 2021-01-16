package model;

import java.util.Iterator;
import java.util.Objects;

public class GeneralList<T> implements Iterable<T> {

    private T[] items;
    private int count;

    public GeneralList() {
        this.items = (T[]) new Object[10];
    }

    public boolean isContain(T obj) {
        for (int i = 0; i < count; i++) {
            if (obj.equals(items[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean add(T obj) {
        Objects.requireNonNull(obj);
        if (count == items.length) {
            expand();
        }
        items[count++] = obj;
        return true;
    }

    public void setItems(T[] items) {
        this.items = items;
    }

    public boolean delete(T obj) {
        for (int i = 0; i < count; i++) {
            if (obj.equals(items[i])) {
                for (int j = i + 1; j < count; j++) {
                    items[i] = items[j];
                }
                items[--count] = null;
                return true;
            }
        }
        return false;
    }

    public T getItemAt(int ind) {
        if (ind >= count) {
            return null;
        }
        return items[ind];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < count; i++) {
            str.append(i + ".").append(items[i].toString()).append("\n");
        }
        return str.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pointer;

            @Override
            public boolean hasNext() {
                return pointer < GeneralList.this.count;
            }

            @Override
            public T next() {
                return GeneralList.this.items[pointer++];
            }
        };
    }

    private void expand() {
        T[] temp = (T[]) new Object[this.items.length + 5];
        System.arraycopy(this.items, 0, temp, 0, count);
        this.items = temp;
    }

}
