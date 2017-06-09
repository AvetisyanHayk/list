package be.howest.util;

import java.util.Comparator;

/**
 *
 * @author Hayk
 * @param <E>
 */
public class BinaryTreeNode<E> {

    private E element;
    private BinaryTreeNode<E> left;
    private BinaryTreeNode<E> right;
    private Comparator<E> comparator;

    public BinaryTreeNode(E element) {
        this(element, null);
    }

    public BinaryTreeNode(E element, Comparator<E> comparator) {
        this(element, null, null, comparator);
    }
    
    public BinaryTreeNode(E element, BinaryTreeNode<E> left,
            BinaryTreeNode<E> right) {
        this(element, left, right, null);
    }
    
    public BinaryTreeNode(E element, BinaryTreeNode<E> left,
            BinaryTreeNode<E> right, Comparator<E> comparator) {
        if (element == null) {
            throw new IllegalArgumentException(
                    "Null elements are not allowed in a BinaryTreeNode");
        }
        set(element);
        setLeft(left);
        setRight(right);
        setComparator(comparator);
    }

    public E get() {
        return element;
    }

    public final void set(E element) {
        this.element = element;
    }

    public final void setComparator(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public Comparator<E> getComparator() {
        return comparator;
    }

    public final void setLeft(BinaryTreeNode<E> left) {
        this.left = left;
    }

    public BinaryTreeNode<E> getLeft() {
        return left;
    }

    public final void setRight(BinaryTreeNode<E> right) {
        this.right = right;
    }

    public BinaryTreeNode<E> getRight() {
        return right;
    }

    public void add(E element) {
        throw new UnsupportedOperationException();
    }

    public void add(BinaryTreeNode<E> node) {
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    public int getHeight() {
        throw new UnsupportedOperationException();
    }
}
