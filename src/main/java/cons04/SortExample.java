package cons04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortExample {
   public static void main(String[] args) {
      List<Book> list =       new ArrayList<>(List.of(
              new Book("Капитанская дочка", "Пушкин", 545),
              new Book("Игрок", "Достоевский", 571),
              new Book("Кавказский пленник", "Лермонтов", 597),
              new Book("Мёртвые души", "Гоголь", 842),
              new Book("Облако в штанах", "Маяковский", 495)
      ));


      //сортировка по цене
      list.sort((a, b) -> Double.compare(a.price, b.price));
      list.forEach(element -> System.out.println(element));

      // сортировка по автору
      list.sort((a, b) -> a.author.compareTo(b.author));
      list.forEach(element -> System.out.println(element));


      //эффективно финальная переменная
      list.sort(Comparator.comparing(a -> a.name));
      String msg = "Книга: ";
//      msg = msg + " ";
      list.forEach(element -> System.out.println(msg + element));

   }

}

/**
 * Что можно использовать в ƛ-выражениях?
 * ● То же, что и в локальных анонимных классах: все
 * элементы, видимые обрамляющим классом:
 * ○ константы
 * ○ статические переменные
 * ○ локальные final переменные
 * ○ “эффективно финальные” локальные переменные
 * ● Нельзя использовать:
 * ○ локальные переменные, значение которых
 * изменялось
 */

/**
 * Функциональный интерфейс
 * ● Функциональный интерфейс - это интерфейс с единственным
 * абстрактным методом (     отличным от методов класса Object)
 * ● Использовать лямбда-выражения можно лишь там, где
 * предполагается использование функционального интерфейса
 * public TreeSet(Comparator<? super E> comparator)
 * {
 *    this(new TreeMap<>(comparator));
 * }
 * new TreeSet<>((o1, o2) -> Integer.compare(Math.abs(o1), Math.abs(o2)));
 *
 * @FunctionalInterface
 * public interface Comparator<T>
 * {
 *       int compare(T o1, T o2);
 *       boolean equals(Object obj); // метод класса Object
 *       // ... default или static методы
 * }
 */

/**
 * Какой тип у самого ƛ-выражения?
 * ● Поскольку ƛ-выражение передаётся как параметр
 * в функцию, то у него самого должен быть какой-то тип
 * ● ƛ-выражение  имеет тип Object, реализующий какой-
 * то функциональный интерфейс
 */

