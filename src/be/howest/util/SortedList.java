package be.howest.util;

import java.util.Comparator;

/**
 *
 * @author Hayk
 * @param <E>
 */
public interface SortedList<E> extends List<E> {
    void setComparator(Comparator<E> comparator);
    Comparator<E> getComparator();
}
