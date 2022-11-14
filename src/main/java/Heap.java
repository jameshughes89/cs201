public interface Heap<T extends Comparable<? super T>> {

    /**
     * Add the provided element to the heap such that the heap ordering is preserved.
     *
     * @param element Element to be added to the heap.
     * @return true if the element was added successfully, false otherwise.
     */
    boolean add(T element);

    /**
     * Remove the element at the top of the heap. This may be the min or max element depending on the specific heap
     * implementation.
     *
     * @return Element at the top of the heap.
     */
    T remove();

    /**
     * Return the element at the top of the heap, but leave it at the top of the heap. This element may be the min or
     * max element depending on the specific heap implementation.
     *
     * @return Element at the top of the heap.
     */
    T peek();

    /**
     * Checks if the heap is empty.
     *
     * @return true if the heap is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Return the number of elements within the heap.
     *
     * @return Number of elements within the heap.
     */
    int size();
}
