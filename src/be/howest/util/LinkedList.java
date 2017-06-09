package be.howest.util;

/**
 *
 * @author Hayk
 * @param <E>
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
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = head;
        for (int i = 0; i < size(); i++) {
            if (element.equals(node.element)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public E get(int index) {
        validateBounds(index, 0, size() - 1);
        return getNodeAt(index).element;
    }

    @Override
    public void set(int index, E element) {
        validateBounds(index, 0, size() - 1);
        getNodeAt(index).element = element;
    }

    @Override
    public void add(E element) {
        if (head == null) {
            head = new Node<>(element);
        } else {
            add(element, head);
        }
    }

    private void add(E element, Node<E> node) {
        if (node.next == null) {
            node.next = new Node<>(element);
        } else {
            add(element, node.next);
        }
    }

    @Override
    public void add(int index, E element) {
        validateBounds(index, 0, size());
        if (index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<E> node = getNodeAt(index - 1);
            node.next = new Node<>(element, node.next);
        }
    }

    @Override
    public void remove(int index) {
        validateBounds(index, 0, size() - 1);
        if (index == 0) {
            head = head.next;
        } else {
            Node<E> node = getNodeAt(index - 1);
            node.next = node.next.next;
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
        head = null;
    }

    private Node<E> getNodeAt(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void validateBounds(int index, int minIndex, int maxIndex) {
        if (index < minIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is lower than minIndex " + minIndex);
        }
        if (index > maxIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is higher than maxIndex " + maxIndex);
        }
    }

    private static class Node<E> {

        E element;
        Node<E> next;

        Node(E element) {
            this(element, null);
        }

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
