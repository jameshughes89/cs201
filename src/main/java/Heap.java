import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * A heap with the ordering defined by a Comparator, which is to be provided to the constructor. The top of the heap
 * will always be the minimum element, as defined by the ordering.
 *
 * @param <T> Type of elements that are to be in the heap.
 */
public class Heap<T> {

    private static final int DEFAULT_CAPACITY = 100;

    private int size;
    private T[] heap;
    private Comparator<T> comparator;

    /**
     * Create a heap with the specified comparator defining the ordering of the elements.
     *
     * @param comparator Comparator defining the order of the elements in the heap
     */
    public Heap(Comparator<T> comparator) {
        size = 0;
        heap = (T[]) new Object[DEFAULT_CAPACITY];
        this.comparator = comparator;
    }

    private void bubbleUp(int index) {
        int currentIndex = index;
        int parentIndex = getParent(size);
        while (currentIndex != 0 && comparator.compare(heap[currentIndex], heap[parentIndex]) < 0) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = getParent(currentIndex);
        }
    }

    private void bubbleDown(int index) {
        int swapChild = index;
        int leftChild = getLeft(index);
        int rightChild = getRight(index);
        if (leftChild < size() && comparator.compare(heap[swapChild], heap[leftChild]) > 0) {
            swapChild = leftChild;
        }
        if (rightChild < size() && comparator.compare(heap[swapChild], heap[rightChild]) > 0) {
            swapChild = rightChild;
        }
        if (swapChild != index) {
            swap(index, swapChild);
            bubbleDown(swapChild);
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

    /**
     * Add the provided element to the heap.
     *
     * @param element Element to be added to the heap
     * @return true if the element was added successfully, false otherwise
     */
    boolean add(T element) {
        if (size() == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
        heap[size] = element;
        bubbleUp(size);
        size++;
        return true;
    }

    /**
     * Remove and return the element at the top of the heap.
     *
     * @return Element at the top of the heap
     * @throws NoSuchElementException If the heap is empty
     */
    T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Heap");
        }
        T toReturn = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        bubbleDown(0);
        return toReturn;
    }

    /**
     * Return, but do not remove, the element at the top of the heap.
     *
     * @return Element at the top of the heap
     * @throws NoSuchElementException If the heap is empty
     */
    T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Heap");
        }
        return heap[0];
    }

    /**
     * Checks if the heap is empty.
     *
     * @return true if the heap is empty, false otherwise
     */
    boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Return the number of elements within the heap.
     *
     * @return Number of elements within the heap
     */
    int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size(); i++) {
            stringBuilder.append(heap[i]);
            if (i < size() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
