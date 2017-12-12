package Model;
import java.util.*;

public class MyDictionary<K, V> implements MyIDictionary<K,V> , Cloneable{
    private Map<K, V> dict = new HashMap<>();

    public MyDictionary() {
        this.dict = new HashMap<>();
    }

    @Override
    public void add(K key, V val) {
        dict.put(key, val);
    }

    @Override
    public Set<K> keySet() {
        return dict.keySet();
    }

    @Override
    public Collection<V> values() {
        return dict.values();
    }

    @Override
    public V getValue(K key) {
        return dict.get(key);
    }

    @Override
    public void remove(K key) {
        dict.remove(key);
    }

    @Override
    public Iterable<Map.Entry<K, V>> getAll() {
        return dict.entrySet();
    }

    @Override
    public String toString() {
        return dict.toString();
    }

    @Override
    public Map<K,V> get() {
        return dict;
    }

    @Override
    public boolean hasKey(K key) {
        return dict.containsKey(key);
    }

    @Override
    public void setContent(Map<K, V> kvMap) {
        this.dict = kvMap;
    }

    public Object clone() throws CloneNotSupportedException {
        MyDictionary theClone = (MyDictionary) super.clone();
        return theClone;
    }

}
