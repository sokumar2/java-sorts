package tree;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {

    private Integer[] elements = {4, 2, 5, 3, 1};

    @Test
    public void testInorder() {
        BinarySearchTree<Integer> bsTree = new BinarySearchTree<Integer>();
        assertEquals("Empty binary search tree should return nothing.", "", bsTree.inorder());

        for(Integer element: elements) {
            bsTree.insert(element);
        }

        assertEquals("The inorder traversal is correct", "12345", bsTree.inorder());
    }

    @Test
    public void testPreorder() {
        BinarySearchTree<Integer> bsTree = new BinarySearchTree<Integer>();

        for(Integer element: elements) {
            bsTree.insert(element);
        }

        assertEquals("The preorder traversal is correct", "42135", bsTree.preorder());
    }

    @Test
    public void testPostorder() {
        BinarySearchTree<Integer> bsTree = new BinarySearchTree<Integer>();

        for(Integer element: elements) {
            bsTree.insert(element);
        }

        assertEquals("The post order traversal is correct", "13254", bsTree.postorder());
    }

    @Test
    public void testMinimum() {
        BinarySearchTree<Integer> bsTree = new BinarySearchTree<Integer>();

        for(Integer element: elements) {
            bsTree.insert(element);
        }

        assertEquals("The minimum value returned is correct", Integer.valueOf(1), bsTree.minimum());
    }

    @Test
    public void testMaximum() {
        BinarySearchTree<Integer> bsTree = new BinarySearchTree<Integer>();

        for(Integer element: elements) {
            bsTree.insert(element);
        }

        assertEquals("This maximum value returned is correct", Integer.valueOf(5), bsTree.maximum());
    }

    @Test
    public void testDelete() {
        BinarySearchTree<Integer> bsTree = new BinarySearchTree<Integer>();

        for(Integer element: elements) {
            bsTree.insert(element);
        }

        bsTree.delete(5);
        assertEquals("The deleted element is no longer in the binary search tree", "1234", bsTree.inorder());
    }

}
