import java.util.Collection;

public interface MyList<E> {

    void add(E e);

    void addAll(Collection<? extends E> c);

    void clear();

    E get(int index);

    boolean isEmpty();

    void remove(int index);

    boolean remove(E e);

    int size();

}
