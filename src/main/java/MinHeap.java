import java.util.Iterator;

public class MinHeap<T extends Comparable<? super T>> implements Heap<T> {

    private static final int DEFAULT_CAPACITY = 100;

    private int size;
    private T[] heap;

    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MinHeap(int initialCapacity) {
        heap = (T[]) new Object[initialCapacity];
        size = 0;
    }

    @Override
    public boolean add(T element) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
