package tree.contract;

/**
 * BinaryTreeInterface
 *
 * This interface defines a contract for a Binary Tree
 *
 * The Interface Segregation Principle states that
 * clients should not be forced to implement interfaces they don't use.
 *
 * Instead of one fat interface many small interfaces
 * are preferred based on groups of methods,
 * each one serving one submodule.
 *
 * @see <a href="https://www.oodesign.com/interface-segregation-principle">Interface Segregation Principle</a>
 *
 * So additional methods for an implementation of a Binary Tree such
 * as a Binary Search Tree is defined in a seperate interface
 */
public interface BinaryTreeInterface<T> {

    /**
     * Insert an element in the tree
     *
     * @param data A generic data type
     */
    public void insert(T data);

    /**
     * Delete an element from the tree
     *
     * @param data A generic data type
     */
    public void delete(T data);

    /**
     * Search if given data exists in the symbol table
     *
     * @param data
     * @return The data itself
     */
    public T contains(T data);

    /**
     * Traverse the binary tree in inorder.
     *
     * @return String representation of the inorder traversal
     */
    public String inorder();

    /**
     * Traverse the binary tree in preorder.
     *
     * @return String representation of the preorder traversal
     */
    public String preorder();

    /**
     * Traverse the binary tree in postorder.
     *
     * @return String representation of the postorder traversal
     */
    public String postorder();
}
