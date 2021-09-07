package cons01.lecture.collect;

/**
 * 03.09.2021
 * 07. Custom Collections
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class LinkedList<T> implements List<T> {

    private static class Node<V> {
        V value;
        Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    private Node<T> first;
    private Node<T> last;

    private int count;

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (count == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }

        last = newNode;
        count++;
    }

    @Override
    public T get(int index) {
        // TODO: сделать проверку, чтобы 0 <= index < count

        // начинаем с первого элемента
        // current - бегунок, который проходится по всем узлам
        Node<T> current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    private class LinkedListIterator implements Iterator<T> {
        Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            // запоминаем текущее значение
            T value = current.value;
            // двигаем курсор
            current = current.next;
            // возвращаем значение
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
}
