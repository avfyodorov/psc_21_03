package cons01.lecture.collect;

/**
 * 03.09.2021
 * 07. Custom Collections
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface List<E> {
    void add(E element);
    E get(int index);

    Iterator<E> iterator();
}
