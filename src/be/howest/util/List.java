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
public interface List<E> {
    int size();
    int indexOf(E element);
    E get(int index);
    void set(int index, E element);
    void add(E value);
    void add(int index, E element);
    void remove(int index);
    boolean remove(E element);
    boolean removeAll(E element);
    void clear();
}
