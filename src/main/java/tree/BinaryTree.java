package tree;

public abstract class BinaryTree<T> {

    public class Node<E> {
        public E data;

        public Node<E> left;

        public Node<E> right;

        public Node(E data) {
            this.data = data;

            left = right = null;
        }
    }

}
