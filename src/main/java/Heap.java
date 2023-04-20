import java.util.NoSuchElementException;

/**
 * A heap with the ordering defined by either the natural ordering of the elements within the heap or by a
 * Comparator, which can be provided to a constructor. The top of the heap will always be the minimum element, as
 * defined by the ordering.
 * <p>
 * If no Comparator is provided to the constructor, the heap will order the elements based on the natural ordering of
 * the elements. This means that the elements within the heap must be comparable. If a Comparator is provided, the
 * elements do not need to be comparable as the elements are ordered based on the Comparator, regardless of the
 * natural ordering of the elements that may exist.
 *
 * @param <T> Type of elements that are to be in the heap. If a comparator is not provided, then T must be comparable
 *            in order to use the natural ordering of the elements.
 */
public class Heap<T> {

    /**
     * Add the provided element to the heap.
     *
     * @param element Element to be added to the heap
     * @return true if the element was added successfully, false otherwise
     */
    boolean add(T element) {
        return false;
    }

    /**
     * Remove and return the element at the top of the heap.
     *
     * @return Element at the top of the heap
     * @throws NoSuchElementException If the heap is empty
     */
    T remove() {
        return null;
    }

    /**
     * Return, but do not remove, the element at the top of the heap.
     *
     * @return Element at the top of the heap
     * @throws NoSuchElementException If the heap is empty
     */
    T peek() {
        return null;
    }

    /**
     * Checks if the heap is empty.
     *
     * @return true if the heap is empty, false otherwise
     */
    boolean isEmpty() {
        return false;
    }

    /**
     * Return the number of elements within the heap.
     *
     * @return Number of elements within the heap
     */
    int size() {
        return 0;
    }
}
