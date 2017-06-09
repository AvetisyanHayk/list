package be.howest.util;

import java.util.Comparator;

/**
 *
 * @author Hayk
 * @param <E>
 */
public class BinaryTree<E> {

    private BinaryTreeNode<E> root;
    private Comparator<E> comparator;

    public BinaryTree() {
        this(null, null);
    }

    public BinaryTree(BinaryTreeNode<E> root) {
        this(root, null);
    }
    
    public BinaryTree(Comparator<E> comparator) {
        this(null, comparator);
    }
    
    public BinaryTree(BinaryTreeNode<E> root, Comparator<E> comparator) {
        set(root);
        setComparator(comparator);
    }

    public BinaryTreeNode<E> get() {
        return root;
    }

    public final void set(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public final void setComparator(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public Comparator<E> getComparator() {
        return comparator;
    }

    public void setLeft(BinaryTreeNode<E> left) {
        root.setLeft(left);
    }

    public BinaryTreeNode<E> getLeft() {
        return root.getLeft();
    }

    public void setRight(BinaryTreeNode<E> right) {
        root.setRight(right);
    }

    public BinaryTreeNode<E> getRight() {
        return root.getRight();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(E element) {
        if (root == null) {
            root = new BinaryTreeNode<>(element);
        } else {
            root.add(element);
        }
    }

    public void add(BinaryTreeNode<E> node) {
        if (root == null) {
            set(node);
        } else {
            root.add(node);
        }
    }

    public BinaryTreeNode<E> removeLeft() {
        throw new UnsupportedOperationException();
    }

    public BinaryTreeNode<E> removeRight() {
        throw new UnsupportedOperationException();
    }

    public void removeBoth() {
        throw new UnsupportedOperationException();
    }

    public int getSize() {
        if (root == null) {
            return 0;
        }
        return root.getSize();
    }

    public int getHeight() {
        if (root == null) {
            return 0;
        }
        return root.getHeight();
    }
}
