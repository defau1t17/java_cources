package collections;

public class MyArrayList<T> implements MyList<T> {

    private Object[] elements = new Object[10];

    private int size = 0;

    private void grow() {

    }


    @Override
    public void add(T o) {
        elements[size] = o;
        size++;
    }

    @Override
    public T get(int index) {
        return (T) elements[index];
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
