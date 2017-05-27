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
public final class DoublyLinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;

    public DoublyLinkedList() {
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
        return getNodeAt(index).next.element;
    }

    @Override
    public void set(int index, E element) {
        validateBounds(index, 0, size() - 1);
        if (size() == 0) {
            head.next = new Node<>(element);
            tail.previous = head.next;
        } else {
            getNodeAt(index).next.element = element;
        }
    }

    @Override
    public void add(E element) {
        Node<E> lastNode = getLastNode();
        lastNode.next = new Node<>(element);
        tail.previous = lastNode.next;
        tail.previous.previous = lastNode;
    }

    @Override
    public void add(int index, E element) {
        validateBounds(index, 0, size());
        if (head == null || index == size()) {
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
        int size = size();
        validateBounds(index, 0, size - 1);
        if (head != null) {
            Node<E> current = getNodeAt(index);
            current.next = current.next.next;
            if (index == size - 1) {
                tail.previous = getLastNode().next;
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
        tail = new Node<>(null);
    }

    @Override
    public void addFirst(E element) {
        add(0, element);
    }

    @Override
    public void addLast(E element) {
        add(element);
    }

    @Override
    public E removeFirst() {
        E element = get(0);
        remove(0);
        return element;
    }

    @Override
    public E removeLast() {
        int index = size() - 1;
        E element = get(index);
        remove(index);
        return element;
    }

    @Override
    public String forwardStringVersionOfList() {
        int size = size();
        StringBuilder sb = new StringBuilder();
        if (size == 1) {
            sb.append(head.next.element);
        } else if (size > 1) {
            Node<E> current = head;
            for (int i = 0; i < size - 1; i++) {
                sb.append(current.next.element).append("\n");
                current = current.next;
            }
            sb.append(tail.previous.element);
        }
        return sb.toString();
    }

    @Override
    public String backwardStringVersionOfList() {
        int size = size();
        StringBuilder sb = new StringBuilder();
        if (size == 1) {
            sb.append(tail.previous.element);
        } else if (size > 1) {
            Node<E> current = tail;
            for (int i = 0; i < size - 1; i++) {
                sb.append(current.previous.element).append("\n");
                current = current.previous;
            }
            sb.append(current.previous.element);
        }
        return sb.toString();
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

        Node<E> previous;
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
        }
    }
}
