package Model;

import java.util.Collection;

public interface MyIStack<T> {
    T pop();
    void push(T e);
    boolean isEmpty();
    Iterable<T> getAll();
}
