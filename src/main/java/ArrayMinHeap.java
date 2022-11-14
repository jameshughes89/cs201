import java.util.Iterator;

public class ArrayMinHeap<T extends Comparable<? super T>> implements Heap<T> {

    private static final int DEFAULT_CAPACITY = 100;

    private int size;
    private T[] heap;

    /**
     * Create a new empty heap with the array container being created with the default capacity.
     */
    public ArrayMinHeap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Create a new empty heap with the array container being created with the specified capacity.
     *
     * @param initialCapacity
     */
    public ArrayMinHeap(int initialCapacity) {
        heap = (T[]) new Comparable[initialCapacity];
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
    public boolean isEmpty() {
        return this.size == 0;
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
