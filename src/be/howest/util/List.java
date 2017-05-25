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
public interface List<V> {
    int size();
    int indexOf(V value);
    V get(int index);
    void set(int index, V value);
    void add(V value);
    void add(int index, V value);
    void remove(int index);
    boolean remove(V value);
    boolean removeAll(V value);
    void clear();
}
