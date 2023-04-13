import java.util.Arrays;
import java.util.NoSuchElementException;

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
        if (size() == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size] = element;
        bubbleUp(size);
        size++;
        return true;
    }

    private void bubbleUp(int index) {
        int currentIndex = index;
        int parentIndex = getParent(size);
        while (currentIndex != 0 && heap[currentIndex].compareTo(heap[parentIndex]) < 0) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = getParent(currentIndex);
        }
    }

    private void swap(int currentIndex, int parentIndex) {
        T temp = heap[parentIndex];
        heap[parentIndex] = heap[currentIndex];
        heap[currentIndex] = temp;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Peeking from empty heap");
        }
        return heap[0];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }
}
