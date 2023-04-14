import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * A heap with the ordering defined by either the natural ordering of the elements within the heap or by a
 * Comparator, which can be provided to a constructor. The top of the heap will always be the minimum element, as
 * defined by the ordering.
 * <p>
 * If no Comparator is provided to the constructor, the heap will order the elements based on the natural ordering of
 * the elements. This means that the elements within the heap must be comparable, otherwise adding to the heap will
 * cause a ClassCastException to be thrown. If a Comparator is provided, the elements do not need to be comparable as
 * the elements are ordered based on the Comparator, regardless of the natural ordering of the elements that may exist.
 *
 * @param <T> Type of elements that are to be in the heap. If a comparator is not provided, then T must be comparable
 *            in order to use the natural ordering of the elements, otherwise a ClassCastException is thrown when
 *            adding.
 */
public class Heap<T> {

    private static final int DEFAULT_CAPACITY = 100;

    private int size;
    private T[] heap;
    private Comparator<T> comparator;

    /**
     * Create a heap with a natural order comparator defining the ordering of the elements..
     */
    public Heap() {
        this((Comparator<T>) Comparator.naturalOrder());
    }

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
        int largerChild = index;
        int leftChild = getLeft(index);
        int rightChild = getRight(index);
        int comparison = comparator.compare(heap[largerChild], heap[leftChild]);
        if (leftChild < size() && comparison > 0) {
            largerChild = leftChild;
        }
        if (rightChild < size() && comparison > 0) {
            largerChild = rightChild;
        }
        if (largerChild != index) {
            swap(index, largerChild);
            bubbleDown(largerChild);
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
