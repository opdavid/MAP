package Model;

import java.util.Vector;

public class MyList<T> implements MyIList<T> {
    private Vector<T> list;

    public MyList() {
        this.list = new Vector<T>();
    }

    @Override
    public void add(T elem) {
        this.list.add(elem);
    }

    @Override
    public T get(int index) {
        return this.list.get(index);
    }

    @Override
    public boolean remove(T elem) {
        return this.list.remove(elem);
    }

    @Override
    public T remove(int index) {
        return this.remove(index);
    }

    @Override
    public int size() {
        return this.list.capacity();
    }

    @Override
    public Vector<T> toList() {
        return this.list;
    }

    @Override
    public Iterable<T> getAll() {
        return list;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
