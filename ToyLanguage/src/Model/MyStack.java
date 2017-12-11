package Model;

import java.util.Collection;
import java.util.Stack;

public class MyStack<T> implements MyIStack<T> {
    private Stack<T> stack;

    public MyStack() {
        this.stack = new Stack<T>();
    }

    @Override
    public T pop() {
        return stack.pop();
    }

    @Override
    public void push(T e) {
        stack.push(e);
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public Iterable<T> getAll() {
        return stack;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
