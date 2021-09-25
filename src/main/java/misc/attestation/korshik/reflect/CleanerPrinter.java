package misc.attestation.korshik.reflect;

import java.lang.reflect.Array;
import java.util.*;

public class CleanerPrinter {

    public void cleanup(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) {
        ReflectionProcessor processor;

        if (checkMapImplement(object.getClass())) {
            processor = new MapProcessor(object);
        } else {
            processor = new ObjectProcessor(object);
        }

        processor.process(fieldsToCleanup, fieldsToOutput);

    }

    /**
     * возвращает объект с дефолтным значением типа <code>T</code>
     *
     * @param targetClass класс для которого необходимо найти дефолтное значение
     * @param <T>         тип объекта для которого находим дефолтное значение
     * @return объект запрашиваемого типа
     */
    public static <T> T getDefaultValue(Class<T> targetClass) {
        return (T) Array.get(Array.newInstance(targetClass, 1), 0);
    }

    /**
     * Возвращает строковое представление объекта <code>value</code>
     *
     * @param value значение, которое необходимо явно преобразовать в строку
     * @return строку из примитивного типа или класса
     */
    public static String valueToString(Object value) {
        String valueInString;

        if (value.getClass().isPrimitive()) {
            valueInString = String.valueOf(value);
        } else {
            valueInString = value.toString();
        }

        return valueInString;
    }


    /**
     * проверяет наследование от <code>Map</code> рекурсивно в несколько уровней наследования и имплементации
     *
     * @param checkedClass проверяемый класс
     * @return <code>true</code> если найдена связь, <code>false</code> если такой связи нет
     */
    private boolean checkMapImplement(Class<?> checkedClass) {
        Class<?>[] interfaces = checkedClass.getInterfaces();

        if (interfaces.length == 0) {
            return false;
        }

        for (Class<?> checkingInterface : interfaces) {
            if (checkingInterface.isAssignableFrom(Map.class) || checkMapImplement(checkingInterface)) {
                return true;
            }
        }

        return false;
    }
}
