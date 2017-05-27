package be.howest.util;

public final class ArrayList<E> implements List<E> {

    private E[] elements;
    private int size;
    private static final int STEP = 10;

    public ArrayList() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public void set(int index, E element) {
        elements[index] = element;
    }

    @Override
    public void add(E element) {
        ensureCapacity(true);
        elements[size] = element;
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(true);
        for (int i = size; i > index; i--) {
            set(i, elements[i - 1]);
        }
        set(index, element);
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            if (index < size - 1) {
                set(i, elements[i + 1]);
            } else {
                set(i, null);
                ensureCapacity(false);
            }
        }
        size--;
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if (index >= 0) {
            remove(index);
        }
        return index >= 0;
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
        elements = (E[]) new Object[STEP];
        size = 0;
    }

    private void ensureCapacity(boolean toEncrease) {
        if (size % STEP == 0) {
            E[] copyArray;
            if (toEncrease) {
                copyArray = (E[]) new Object[size + STEP];
            } else {
                copyArray = (E[]) new Object[size - STEP];
            }
            for (int i = 0; i < elements.length; i++) {
                copyArray[i] = elements[i];
            }
            elements = copyArray;
        }
    }
}