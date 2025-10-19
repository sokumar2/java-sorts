package tree;

import tree.contract.BinaryTreeInterface;
import tree.contract.BinarySearchTreeInterface;

public class BinarySearchTree<T extends Comparable<T>>
    extends BinaryTree<T>
    implements BinaryTreeInterface<T>, BinarySearchTreeInterface<T> {

    private Node<T> head;

    public void insert(T data) {
        head = insert(head, data);
    }

    private Node<T> insert(Node<T> head, T data) {
        if (null == head) {
            head = new Node<T>(data);
        } else {
            T value = head.data;

            if (value.compareTo(data) >= 0) {
                head.left = insert(head.left, data);
            } else {
                head.right = insert(head.right, data);
            }
        }

        return head;
    }

    public void delete(T data) {
        head = delete(head, data);
    }

    private Node<T> delete(Node<T> head, T data) {
        if (null == head) {
            return head;
        }

        T value = head.data;

        if (value.compareTo(data) < 0) head.right = delete(head.right, data);
        else if (value.compareTo(data) > 0) head.left = delete(head.left, data);
        else {
            if (null == head.left) return head.right;
            else if (null == head.right) return head.left;
            else {
                head.data = this.successor(head.right);
                head.right = delete(head.right, head.data);
            }
        }

        return head;
    }

    public String inorder() {
        StringBuilder stringBuilder = new StringBuilder();

        inorder(head, stringBuilder);

        return stringBuilder.toString();
    }

    private void inorder(Node<T> head, StringBuilder stringBuilder) {
        if (null == head) {
            return;
        }

        this.inorder(head.left, stringBuilder);

        stringBuilder.append(String.valueOf(head.data));

        this.inorder(head.right, stringBuilder);
    }

    public String preorder() {
        StringBuilder stringBuilder = new StringBuilder();

        preorder(head, stringBuilder);

        return stringBuilder.toString();
    }

    private void preorder(Node<T> head, StringBuilder stringBuilder) {
        if (null == head) {
            return;
        }

        stringBuilder.append(String.valueOf(head.data));

        preorder(head.left, stringBuilder);

        preorder(head.right, stringBuilder);
    }

    public String postorder() {
        StringBuilder stringBuilder = new StringBuilder();

        postorder(head, stringBuilder);

        return stringBuilder.toString();
    }

    private void postorder(Node<T> head, StringBuilder stringBuilder) {
        if (null == head) {
            return;
        }

        postorder(head.left, stringBuilder);

        postorder(head.right, stringBuilder);

        stringBuilder.append(String.valueOf(head.data));
    }

    public T minimum() {
        if (null == head) {
            return null;
        }

        return minimum(head);
    }

    private T minimum(Node<T> head) {
        if (null == head.left) {
            return head.data;
        }

        return minimum(head.left);
    }

    public T maximum() {
        if (null == head) {
            return null;
        }

        return maximum(head);
    }

    private T maximum(Node<T> head) {
        if (null == head.right) {
            return head.data;
        }

        return maximum(head.right);
    }

    public T contains(T data) {
        return contains(head, data);
    }

    private T contains(Node<T> head, T data) {
        if (null == head) {
            return null;
        } else {
            T value = head.data;

            if (value.compareTo(data) > 0) return contains(head.left, data);
            else if (value.compareTo(data) < 0) return contains(head.right, data);

            return head.data;
        }
    }

    private T successor(Node<T> head) {
        if (null != head.left && null != head.right) {
            return head.data;
        }

        return successor(head.left);
    }

}
