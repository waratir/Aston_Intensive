import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class MyArrayList<E> implements MyList<E> {
    private final static int DEFAULT_CAPACITY = 16;
    private E[] initialArray;
    private int size;

    public MyArrayList() {
        this.size = 0;
        this.initialArray = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(E e) {
        if (size == initialArray.length) {
            initialArray = Arrays.copyOf(initialArray, initialArray.length * 3 / 2 + 1);
        }
        initialArray[size++] = e;
    }

    @Override
    public void addAll(Collection<? extends E> collection) {
        E[] array = (E[]) collection.toArray();

        if (initialArray.length <= size + array.length) {
            initialArray = Arrays.copyOf(initialArray, initialArray.length + array.length);
        }

        System.arraycopy(array, 0, initialArray, this.size, array.length);
        size += collection.size();
    }

    @Override
    public void clear() {
        initialArray = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public E get(int index) {
        return initialArray[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int index) {
        Objects.checkIndex(index, size);
        for (int i = index; i < size; i++) {
            int outOfBoundsIndex = initialArray.length;
            if (i + 1 == outOfBoundsIndex) {
                initialArray[i] = null;
            } else {
                initialArray[i] = initialArray[i + 1];
            }
        }
        this.size--;
    }

    @Override
    public boolean remove(E elem) {
        for (int i = 0; i < size(); i++) {
            if (elem != null && this.get(i) == elem) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(initialArray[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
