/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
