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
public final class LinkedList<V> implements List<V> {

    private Node<V> head;

    public LinkedList() {
        clear();
    }
    
    @Override
    public int size() {
        int size = 0;
        Node<V> current = head;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    @Override
    public int indexOf(V value) {
        Node<V> current = head;
        for (int i = 0; i < size(); i++) {
            if (current.next != null && value.equals(current.next.value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public V get(int index) {
        validateBounds(index, 0, size());
        return getNodeAt(index).next.value;
    }

    @Override
    public void set(int index, V value) {
        validateBounds(index, 0, size() - 1);
        if (size() == 0) {
            head.next = new Node<>(value);
        } else {
            getNodeAt(index).next.value = value;
        }
    }

    @Override
    public void add(V value) {
        getLastNode().next = new Node<>(value);
    }

    @Override
    public void add(int index, V value) {
        validateBounds(index, 0, size());
        if (head == null) {
            add(value);
        } else {
            Node<V> current = getNodeAt(index);
            Node<V> temp = current.next;
            current.next = new Node<>(value);
            current.next.next = temp;
        }
    }

    @Override
    public void remove(int index) {
        validateBounds(index, 0, size() - 1);
        if (head != null) {
            Node<V> current = getNodeAt(index);
            current.next = current.next.next;
        }
    }

    @Override
    public boolean remove(V value) {
        int index = indexOf(value);
        if (index >= 0) {
            remove(indexOf(value));
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(V value) {
        int index = indexOf(value);
        boolean removed = false;
        while (index >= 0) {
            removed = remove(value);
            index = indexOf(value);
        }
        return removed;
    }

    @Override
    public void clear() {
        head = new Node<>(null);
    }
        
    private Node<V> getNodeAt(int index) {
        Node<V> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    
    private Node<V> getLastNode() {
        Node<V> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
    
    private void validateBounds(int index, int minIndex, int maxIndex) {
        if (index < minIndex || index > maxIndex) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static class Node<V> {

        V value;
        Node<V> next;

        Node(V value) {
            this.value = value;
        }
    }
}
