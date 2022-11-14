import java.util.Iterator;

public class LinkedAvlTree<T extends Comparable<? super T>> implements BinarySearchTree<T> {

    private int size;
    private Node<T> root;

    /**
     * Create a new empty avl tree. The root element is set to null.
     */
    public LinkedAvlTree() {
        root = null;
        size = 0;
    }

    @Override
    public boolean add(T element) {
        return false;
    }

    @Override
    public T remove(T element) {
        return null;
    }

    @Override
    public T removeMin() {
        return null;
    }

    @Override
    public T removeMax() {
        return null;
    }

    @Override
    public T min() {
        return null;
    }

    @Override
    public T max() {
        return null;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public int count(T element) {
        return 0;
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

    @Override
    public Iterator<T> preOrderIterator() {
        return null;
    }

    @Override
    public Iterator<T> inOrderIterator() {
        return null;
    }

    @Override
    public Iterator<T> postOrderIterator() {
        return null;
    }

    @Override
    public Iterator<T> levelOrderIterator() {
        return null;
    }

    /**
     * A Node class for a binary linked tree structure. Each node contains a reference to data of type T, which may be
     * null, and a reference to the left and right child binary linked nodes, which may also be null.
     * <p>
     * This class is a static nested class since the node class is only needed for the implementation of the
     * LinkedBinarySearchTree.
     *
     * @param <T> Type of the data being stored in the node
     */
    private static class Node<T> {

        private T data;
        private Node<T> left;
        private Node<T> right;

        private Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        private T getData() {
            return data;
        }

        private void setData(T data) {
            this.data = data;
        }

        private Node<T> getLeft() {
            return left;
        }

        private void setLeft(Node<T> left) {
            this.left = left;
        }

        private Node<T> getRight() {
            return right;
        }

        private void setRight(Node<T> right) {
            this.right = right;
        }
    }
}
