package Model;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface IHeap<Integer> {
    void add(Integer key, Integer value);
    Set<Integer> keySet();
    Collection<Integer> values();
    Integer getValue(Integer key);
    void remove(Integer key);
    Integer newFreeAllocation(Integer val);
    Iterable<Map.Entry<Integer, Integer>> getAll();
    Map<Integer, Integer> get();
    boolean hasKey(Integer key);

    void setContent(Map<Integer, Integer> integerIntegerMap);
}
