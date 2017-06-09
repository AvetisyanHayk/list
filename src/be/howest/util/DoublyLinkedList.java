package be.howest.util;

/**
 *
 * @author Hayk
 * @param <E>
 */
public final class DoublyLinkedList<E> implements Iterable<E> {

    private Node<E> head;
    private Node<E> tail;

    public DoublyLinkedList() {
        clear();
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
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
        validateBounds(index, 0, size());
        return getNodeAt(index).element;
    }

    @Override
    public void set(int index, E element) {
        validateBounds(index, 0, size() - 1);
        getNodeAt(index).element = element;
    }

    @Override
    public void add(E element) {
        addLast(element);
    }

    @Override
    public void addFirst(E element) {
        head = new Node<>(element, head);
        if (size() == 1) {
            tail = head;
        } else {
            head.next.previous = head;
        }
    }

    @Override
    public void addLast(E element) {
        if (head == null) {
            addFirst(element);
        } else {
            add(element, head);
        }
    }

    private void add(E element, Node<E> node) {
        if (node.next == null) {
            node.next = new Node<>(element);
            node.next.previous = node;
            tail = node.next;
        } else {
            add(element, node.next);
        }
    }

    @Override
    public void add(int index, E element) {
        int size = size();
        validateBounds(index, 0, size);
        if (index == size) {
            addLast(element);
        } else if (index == 0) {
            addFirst(element);
        } else {
            Node<E> node = getNodeAt(index - 1);
            node.next = new Node<>(element, node.next, node);
            node.next.previous = node.next;
        }
    }

    @Override
    public void remove(int index) {
        int size = size();
        validateBounds(index, 0, size - 1);
        if (index == size - 1) {
            removeLast();
        } else if (index == 0) {
            removeFirst();
        } else {
            Node<E> node = getNodeAt(index - 1);
            node.next = node.next.next;
            node.next.previous = node;
        }
    }

    @Override
    public E removeFirst() {
        E removed = null;
        if (head != null) {
            removed = head.element;
            head = head.next;
            fixHeadAndTail();
            if (size() <= 1) {
                tail = head;
            }
        }
        return removed;
    }

    @Override
    public E removeLast() {
        E removed = null;
        if (tail != null) {
            removed = tail.element;
            tail = tail.previous;
            fixHeadAndTail();
            if (size() <= 1) {
                head = tail;
            }
        }
        return removed;
    }

    private void fixHeadAndTail() {
        if (head != null) {
            head.previous = null;
            tail.next = null;
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
    public String forwardStringVersionOfList() {
        if (head == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Node<E> node = head;
        while (node.next != null) {
            sb.append(node.element).append("\n");
            node = node.next;
        }
        sb.append(node.element);
        return sb.toString();
    }

    @Override
    public String backwardStringVersionOfList() {
        if (tail == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Node<E> node = tail;
        while (node.previous != null) {
            sb.append(node.element).append("\n");
            node = node.previous;
        }
        sb.append(node.element);
        return sb.toString();
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

        Node<E> previous;
        E element;
        Node<E> next;

        Node(E element) {
            this(element, null);
        }

        Node(E element, Node<E> next) {
            this(element, next, null);
        }

        Node(E element, Node<E> next, Node<E> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }
}
