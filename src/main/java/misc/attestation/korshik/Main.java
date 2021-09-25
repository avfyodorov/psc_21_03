package misc.attestation.korshik;

import misc.attestation.korshik.reflect.CleanerPrinter;

import java.time.LocalDate;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        CleanerPrinter cleanerPrinter = new CleanerPrinter();

        Set<String> fieldsToCleanup = new TreeSet<>();
        fieldsToCleanup.add("name");
        fieldsToCleanup.add("steps");
        fieldsToCleanup.add("surname");

        Set<String> fieldsToOutput = new HashSet<>();
        fieldsToOutput.add("surname");
        fieldsToOutput.add("age");
        fieldsToOutput.add("middleName");
        fieldsToOutput.add("regDate");

        User user = new User("dima", 100, "rkoks", 30, "andr",
                LocalDate.of(2020, 2, 2));

        System.out.println(user);
        cleanerPrinter.cleanup(user, fieldsToCleanup, fieldsToOutput);
        System.out.println(user);

        System.out.println("========================");
        TreeMap<String, Object> map = new TreeMap<>();
        map.put("name", "dima");
        map.put("steps", 100);
        map.put("surname", "rkoks");
        map.put("age", 30.0);
        map.put("middleName", "andr");
        map.put("regDate", LocalDate.of(2020, 2, 2));

        System.out.println(map);
        cleanerPrinter.cleanup(map, fieldsToCleanup, fieldsToOutput);
        System.out.println(map);

    }
}

/**
 * Реализовать метод:
 *
 * void cleanup(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput), принимающий любой
 * объект и две коллекции строк.
 *
 * В объекте поля, перечисленные в fieldsToClenup, установить в значение null, или,
 * если поля примитивных типов, в их значение по умолчанию.
 *
 * Значения полей, перечисленных в fieldsToOutput, сконвертировать в строку
 * (вызвав toString у объектов или String.valueOf для примитивных типов) и
 * вывести результат преобразования в консоль.
 *
 * Если переданный первым параметром объект является реализацией интерфейса Map,
 * то проделать аналогичные операции: для списка fieldsToCleanup удалить ключи,
 * для fieldsToOutput - вывести в консоль значения.
 *
 * При отсутствии в объекте/мапе нужных полей/ключей - падать с IllegalArgumentException, оставив объект неизменным.
 */