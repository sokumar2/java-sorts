package tree.contract;

/**
 * BinarySearchTreeInterface
 */
public interface BinarySearchTreeInterface<T> {

    /**
     * Return the minimum element in a
     * binary search tree.
     *
     * @return An element of generic type
     */
    public T minimum();

    /**
     * Return the maximum element in a
     * binary search tree.
     *
     * @return An element of generic type
     */
    public T maximum();
}
