package cons04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamlpe {
   public static void main(String[] args) {
      List<Book> list =       new ArrayList<>(List.of(
              new Book("Капитанская дочка", "Пушкин", 545),
              new Book("Игрок", "Достоевский", 571),
              new Book("Кавказский пленник", "Лермонтов", 597),
              new Book("Мёртвые души", "Гоголь", 842),
              new Book("Облако в штанах", "Маяковский", 495)
      ));

      // формирование списка по критерию через поток
      List<Book> filtered = list.stream().filter(x -> x.name.contains("Ка")).collect(Collectors.toList());
      // вывод на консоль
      filtered.forEach(System.out::println);

      // количество подходящих элементов через поток
      long num = list.stream().filter(x -> x.name.contains("а")).count();
      System.out.println("Отобрано книг: " + num);

      //лямбда
      Predicate<Book> preLambda = x -> {
         System.out.println(x);
         return x.name.contains("а");
      };
      // количество подходящих элементов через поток
      System.out.println("До stream().filter");
      Stream<Book> test = list.stream().filter(preLambda);
      System.out.println("После stream().filter");
      long num2 = test.count();
      System.out.println("Отобрано книг: " + num2);
/**
 * Выводы по потокам и отложенным операциям
 * ● Потоки (метод stream) на основе коллекций подобны итераторам:
 * они предоставляют механизм доступа к существующим элементам
 * ● При вызове stream.filter для коллекции формируется правило, но не
 * новая структура данных
 * ● stream.filter является отложенной операцией
 * ● Реальное прохождение по элементам коллекции (итерирование)
 * происходит при вызове эффективной операции (count, collect, ...)
 * ● Вызов последовательно нескольких отложенных операций не
 * приводит к нескольким итерациям по списку: все отложенные
 * операции исполняются во время единственной итерации,
 * порождённой терминальной операцией
 * ==========================================
 * По тому ЧТО возвращает метод (операция):
 * ○ Stream - отложенная (промежуточная) операция
 * ○ всё остальное - эффективная (терминальная)
 * операция
 * Терминология
 * ● Синонимы термина “отложенная операция”:
 * ○ промежуточная операция
 * ○ конвейерная операция
 * ○ ленивая операция
 * ● Синонимы термина “терминальная операция”:
 * ○ эффективная операция
 * ○ энергичная операция
 */


// преобразование строки в число через лямбду Function
      Optional<Book> oMax = list.stream().max(Comparator.comparingDouble(x -> x.price));
      Book max = oMax.get();
      System.out.println(max);
/**
 * Тип Optional
 * ● Объект типа Optional - это обёртка вокруг любого другого объекта
 * ● Тип Optional предназначен для предотвращения падения программы по
 * NullPointerException
 * ● В объекте типа Optional может лежать либо другой объект, либо null
 * ● Основные методы
 * ○ Optional.of(<объект>) - обернуть объект <объект> в Optional
 * ○ isPresent() - есть ли реальный объект?
 * ○ ifPresent(<функция>) - выполнить <функция> если есть реальный объект
 * ○ get() - получить этот объект
 * ○ orElse(<значение по умолчанию>) - основной метод, который
 * возвращает реальный объект, если он есть, а если нет (то есть Optional
 * оборачивает null), то возвращает <значение по умолчанию>
  */

// преобразование строки в число через лямбду Function
      Optional<Book> oMax2 = list.stream().max(Comparator.comparingDouble(x -> x.price));
      Book max2 = oMax.get();
      System.out.println(max2);

   }
}
