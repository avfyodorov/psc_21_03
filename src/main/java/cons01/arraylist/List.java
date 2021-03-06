package cons01.arraylist;

public interface List<E> {
    void add(E element);
    E get(int index);

    Iterator<E> iterator();
}
