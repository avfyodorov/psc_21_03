package cons04;

import java.util.function.*;

/**
 * Основные функциональные интерфейсы
 * Имя интерфейса Параметры Возвращает Метод Пример использования
 * Comparator<T> (T, T) int compare(T, T) Определение компаратора (в том числе в методе sort для списков)
 *
 * Predicate<T> Утверждение T boolean test(T) Выбор из коллекций нужных элементов
 * (через фильтры потоков - метод filter)
 * Consumer<T>
 * Потребитель T void accept(T) Однотипные действия с элементами списка
 * (метод forEach коллекций)
 * Function<T,R>
 * Функция T R apply(T, R) По объекту T получить объект R (например,
 * свойство T)
 * Supplier<T>
 * Поставщик - T get() Функция без параметров - поставщик
 * результатов (например, случайных чисел)
 * UnaryOperator<T>
 * Унарная операция T T apply(T) Определяет унарную операцию
 */
public class StdFuncIntr {
   public static void main(String[] args) {
      Predicate<Integer> isEven = x -> x % 2 == 0;
      System.out.println(isEven.test(5));
      System.out.println(isEven.test(1000));

      //     ● Этот функциональный интерфейс используется в forEach
      Consumer<Integer> doIt = x -> System.out.println(x);
      doIt.accept(55555);


      Function<Double, Double> square = x -> x * x;
      System.out.println(square.apply(5.0));

      Function<Double, Double> squareRoot = x -> Math.sqrt(x);
      System.out.println(squareRoot.apply(25.0));

      Function<Double, Double> mod = x -> squareRoot.apply(square.apply(x));
      System.out.println(mod.apply(-5.0));


      Supplier<Integer> randomFactory = () -> (int) (Math.random() * 10 + 1);
      System.out.println("Случайные числа от 1 до 10:");
      for (int i = 0; i < 5; i++)
         System.out.println(randomFactory.get());


      UnaryOperator<Integer> square2 = x -> x * x;
      System.out.println(square2.apply(5));
      System.out.println(square2.apply(-5));

        }
}



