package collections;

import java.util.Map;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private Node<K, V>[] table = new Node<>[16];

    private int size = 0;


    private int getIndex(K key) {
        int hash = key.hashCode();
        int index = hash % table.length;
        return Math.abs(index);

    }

    @Override
    public V put(K key, V value) {

        if (table[getIndex(key)] == null) {
            table[getIndex(key)] = new Node<>(key, value);
        } else {
            Node<K, V> head = table[getIndex(key)];
            while (head.next != null) {
                if (head.key.equals(key)) {
                    head.value = value;
                }
                head = head.next;
            }

        }

        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(K key) {
        Node<K, V> head = table[getIndex(key)];
        while (head.next != null) {
            return head.value;
        }
        return null;
    }

    private static class Node<K, V> implements Map.Entry<K, V> {
        V value;
        K key;

        Node<K, V> next;

        public Node(K key, V value) {
            this.value = value;
            this.key = key;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }
}
