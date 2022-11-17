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

    private void bubbleDown(int index) {
        int swapTo = index;
        int leftChild = getLeft(index);
        int rightChild = getRight(index);
        if (leftChild < size() && heap[swapTo].compareTo(heap[leftChild]) > 0) {
            swapTo = leftChild;
        }
        if (rightChild < size() && heap[swapTo].compareTo(heap[rightChild]) > 0) {
            swapTo = rightChild;
        }
        if (swapTo != index) {
            swap(index, swapTo);
            bubbleDown(swapTo);
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

    private int getLeft(int index) {
        return 2 * index + 1;
    }

    private int getRight(int index) {
        return 2 * index + 2;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Removing from empty heap");
        }
        T toReturn = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        bubbleDown(0);
        return toReturn;
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
