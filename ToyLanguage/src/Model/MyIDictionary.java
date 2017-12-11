package Model;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface MyIDictionary<K, V> {
    void add(K key, V val);
    Set<K> keySet();
    Collection<V> values();
    V getValue(K key) throws MyException;
    void remove(K key);
    Iterable<Map.Entry<K, V>> getAll();
    boolean hasKey(K key);
    Map<K,V> get();
    void setContent(Map<K,V> kvMap);
}
