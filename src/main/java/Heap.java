public interface Heap <T extends Comparable<? super T>> extends Iterable<T> {

    /**
     * Add the provided element to the heap such that the heap ordering is preserved.
     *
     * @param element Element to be added to the heap.
     */
    public void add(T element);

    /**
     * Remove the element at the top of the heap. This may be the min or max element depending on the specific heap
     * implementation.
     *
     * @return Element at the top of the heap.
     */
    public T remove();

    /**
     * Return the element at the top of the heap, but leave it at the top of the heap. This element may be the min or
     * max element depending on the specific heap implementation.
     *
     * @return Element at the top of the heap.
     */
    public T peek();

}