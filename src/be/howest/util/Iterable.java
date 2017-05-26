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
public interface Iterable<V> extends List<V> {
    void addFirst(V value);
    void addLast(V value);
    V removeFirst();
    V removeLast();
    String forwardStringVersionOfList();
    String backwardStringVersionOfList();
}
