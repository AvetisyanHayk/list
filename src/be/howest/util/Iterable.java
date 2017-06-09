package be.howest.util;

/**
 *
 * @author Hayk
 */
public interface Iterable<E> extends List<E> {
    void addFirst(E element);
    void addLast(E element);
    E removeFirst();
    E removeLast();
    String forwardStringVersionOfList();
    String backwardStringVersionOfList();
}
