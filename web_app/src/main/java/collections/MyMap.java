package collections;

public interface MyMap<K, V> {

    V put(K key, V value);

    V remove(K key);

    int size();

    V get(K key);


}
