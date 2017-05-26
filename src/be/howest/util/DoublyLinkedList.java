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
public final class DoublyLinkedList<V> implements Iterable<V> {

    private Node<V> head;
    private Node<V> tail;

    public DoublyLinkedList() {
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
            tail.previous = head.next;
        } else {
            getNodeAt(index).next.value = value;
        }
    }

    @Override
    public void add(V value) {
        Node<V> lastNode = getLastNode();
        lastNode.next = new Node<>(value);
        tail.previous = lastNode.next;
        tail.previous.previous = lastNode;
    }

    @Override
    public void add(int index, V value) {
        validateBounds(index, 0, size());
        if (head == null || index == size()) {
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
        int size = size();
        validateBounds(index, 0, size - 1);
        if (head != null) {
            Node<V> current = getNodeAt(index);
            current.next = current.next.next;
            if (index == size - 1) {
                tail.previous = getLastNode().next;
            }
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
        tail = new Node<>(null);
    }

    @Override
    public void addFirst(V value) {
        add(0, value);
    }

    @Override
    public void addLast(V value) {
        add(value);
    }

    @Override
    public V removeFirst() {
        V value = get(0);
        remove(0);
        return value;
    }

    @Override
    public V removeLast() {
        int index = size() - 1;
        V value = get(index);
        remove(index);
        return value;
    }

    @Override
    public String forwardStringVersionOfList() {
        int size = size();
        StringBuilder sb = new StringBuilder();
        if (size == 1) {
            sb.append(head.next.value);
        } else if (size > 1) {
            Node<V> current = head;
            for (int i = 0; i < size - 1; i++) {
                sb.append(current.next.value).append("\n");
                current = current.next;
            }
            sb.append(tail.previous.value);
        }
        return sb.toString();
    }

    @Override
    public String backwardStringVersionOfList() {
        int size = size();
        StringBuilder sb = new StringBuilder();
        if (size == 1) {
            sb.append(tail.previous.value);
        } else if (size > 1) {
            Node<V> current = tail;
            for (int i = 0; i < size - 1; i++) {
                sb.append(current.previous.value).append("\n");
                current = current.previous;
            }
            sb.append(current.previous.value);
        }
        return sb.toString();
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

        Node<V> previous;
        V value;
        Node<V> next;

        Node(V value) {
            this.value = value;
        }
    }
}
