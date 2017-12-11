package Model;

import java.util.Vector;

public interface MyIList<T> {
    void add(T elem);
    T get(int index);
    boolean remove(T elem);
    T remove(int index);
    int size();
    Vector<T> toList();
    Iterable<T> getAll();
}
