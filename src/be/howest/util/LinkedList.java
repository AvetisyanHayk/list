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
public final class LinkedList<E> implements List<E> {

    private Node<E> head;

    public LinkedList() {
        clear();
    }
    
    @Override
    public int size() {
        int size = 0;
        Node<E> current = head;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    @Override
    public int indexOf(E element) {
        Node<E> current = head;
        for (int i = 0; i < size(); i++) {
            if (current.next != null && element.equals(current.next.element)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public E get(int index) {
        validateBounds(index, 0, size());
        Node<E> node = getNodeAt(index);
        if (node != null && node.next != null) {
            return node.next.element;
        }
        return null;
    }

    @Override
    public void set(int index, E element) {
        validateBounds(index, 0, size() - 1);
        if (size() == 0) {
            head.next = new Node<>(element);
        } else {
            getNodeAt(index).next.element = element;
        }
    }

    @Override
    public void add(E element) {
        getLastNode().next = new Node<>(element);
    }

    @Override
    public void add(int index, E element) {
        validateBounds(index, 0, size());
        if (head == null) {
            add(element);
        } else {
            Node<E> current = getNodeAt(index);
            Node<E> temp = current.next;
            current.next = new Node<>(element);
            current.next.next = temp;
        }
    }

    @Override
    public void remove(int index) {
        validateBounds(index, 0, size() - 1);
        if (head != null) {
            Node<E> current = getNodeAt(index);
            if (current != null && current.next != null)  {
                current.next = current.next.next;
            }
        }
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if (index >= 0) {
            remove(indexOf(element));
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(E element) {
        int index = indexOf(element);
        boolean removed = false;
        while (index >= 0) {
            removed = remove(element);
            index = indexOf(element);
        }
        return removed;
    }

    @Override
    public void clear() {
        head = new Node<>(null);
    }
        
    private Node<E> getNodeAt(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    
    private Node<E> getLastNode() {
        Node<E> current = head;
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

    private static class Node<E> {

        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
        }
    }
}
