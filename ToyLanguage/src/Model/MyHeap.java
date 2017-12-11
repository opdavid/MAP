package Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyHeap implements IHeap<Integer> {
    private Map<Integer,Integer> heap = new HashMap<>();
    private Integer firstFree;
    public MyHeap() {
        firstFree = 1;
    }

    @Override
    public void setContent(Map<Integer, Integer>  heap) {
        this.heap = heap;
    }

    @Override
    public void add(Integer key, Integer value) {
        heap.put(key,value);
    }

    @Override
    public Set<Integer> keySet() {
        return heap.keySet();
    }

    @Override
    public Collection<Integer> values() {
        return heap.values();
    }

    @Override
    public Integer getValue(Integer key) {
        return heap.get(key);
    }

    @Override
    public void remove(Integer key) {
        heap.remove(key);
    }

    @Override
    public Iterable<Map.Entry<Integer, Integer>> getAll() {
        return heap.entrySet();
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    @Override
    public Integer newFreeAllocation(Integer val) {
        heap.put(firstFree, val);
        firstFree++;
        return firstFree - 1;
    }

    @Override
    public boolean hasKey(Integer key) {
        return heap.containsKey(key);
    }

    @Override
    public Map<Integer, Integer> get() {
        return heap;
    }
}
