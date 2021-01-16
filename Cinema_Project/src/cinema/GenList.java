package cinema;

import java.util.Objects;

public class GenList<T> {

    private T[] items;
    private int count;

    public GenList() {
        this.items = (T[]) new Object[100];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < count; i++) {
            str.append(i + ".").append(items[i].toString()).append("\n");
        }
        return str.toString();
    }
    public boolean add(T obj) {
        Objects.requireNonNull(obj);
        if (count == items.length) {
            expand();
        }
        items[count++] = obj;
        return true;
    }
    public boolean isContain(T obj) {
        for (int i = 0; i < count; i++) {
            if (obj.equals(items[i])) {
                return true;
            }
        }
        return false;
    }
    private void expand() {
        T[] temp = (T[]) new Object[this.items.length + 5];
        System.arraycopy(this.items, 0, temp, 0, count);
        this.items = temp;
    }
}
