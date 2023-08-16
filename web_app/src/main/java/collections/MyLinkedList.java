package collections;

import org.w3c.dom.Node;

public class MyLinkedList<T> implements MyList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;


    @Override
    public void add(T o) {
        Node<T> taiil1 = tail;
        Node<T> next = new Node<>(o, null, taiil1);
        taiil1.next = next;
        tail = taiil1;
    }

    @Override
    public T get(int index) {
        if (index < size / 2) {
            Node<T> head1 = head;
            for (int i = 0; i < index; i++) {
                head1 = head.next;
            }
            return head1.object;
        } else {
            Node<T> tail1 = tail;
            for (int i = size; i > index; i--) {
                tail1 = tail.prev;
            }
            return tail1.object;
        }

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<T> {
        T object;
        Node<T> next;
        Node<T> prev;

        public Node(T object, Node<T> next, Node<T> prev) {
            this.object = object;
            this.next = next;
            this.prev = prev;
        }
    }
}
