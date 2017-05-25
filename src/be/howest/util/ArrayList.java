package be.howest.util;

public final class ArrayList<V> implements List<V> {

    private V[] items;
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
    public int indexOf(V value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(items[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V get(int index) {
        return items[index];
    }

    @Override
    public void set(int index, V newValue) {
        items[index] = newValue;
    }

    @Override
    public void add(V value) {
        ensureCapacity(true);
        items[size] = value;
        size++;
    }

    @Override
    public void add(int index, V newValue) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(true);
        for (int i = size; i > index; i--) {
            set(i, items[i - 1]);
        }
        set(index, newValue);
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            if (index < size - 1) {
                set(i, items[i + 1]);
            } else {
                set(i, null);
                ensureCapacity(false);
            }
        }
        size--;
    }

    @Override
    public boolean remove(V value) {
        int index = indexOf(value);
        if (index >= 0) {
            remove(index);
        }
        return index >= 0;
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
        items = (V[]) new Object[STEP];
        size = 0;
    }

    private void ensureCapacity(boolean toEncrease) {
        if (size % STEP == 0) {
            V[] copyArray;
            if (toEncrease) {
                copyArray = (V[]) new Object[size + STEP];
            } else {
                copyArray = (V[]) new Object[size - STEP];
            }
            for (int i = 0; i < items.length; i++) {
                copyArray[i] = items[i];
            }
            items = copyArray;
        }
    }
}