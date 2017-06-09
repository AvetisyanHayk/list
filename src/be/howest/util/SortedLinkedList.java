package be.howest.util;

import java.util.Comparator;

/**
 *
 * @author Hayk
 * @param <E>
 */
public class SortedLinkedList<E> implements SortedList<E> {

    private Comparator<E> comparator;

    public SortedLinkedList() {
        this(null);
    }

    public SortedLinkedList(Comparator<E> comparator) {
        setComparator(comparator);
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(E value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void setComparator(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Comparator<E> getComparator() {
        return comparator;
    }
}
