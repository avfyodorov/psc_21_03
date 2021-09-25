package reflection;

import java.lang.reflect.Field;

public class Validator {
    public void validate(Object form) {
        Class<?> formClass = form.getClass();

        Field[] fields = formClass.getDeclaredFields();

        for (Field field : fields) {
            // проверка минимального числового значения
            if (field.isAnnotationPresent(Min.class)) {
                field.setAccessible(true);
                try {
                    if (field.getDouble(form) < field.getAnnotation(Min.class).value()) {
                        throw new IllegalArgumentException(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(e);
                }
            }

            // проверка максимального числового значения
            if (field.isAnnotationPresent(Max.class)) {
                field.setAccessible(true);
                try {
                    if (field.getDouble(form) > field.getAnnotation(Max.class).value()) {
                        throw new IllegalArgumentException(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(e);
                }
            }

            // проверка максимальной длины
            if (field.isAnnotationPresent(MinMaxLength.class)) {
                field.setAccessible(true);
                try {
                    int fieldLength = ((String) field.get(form)).length();
                    if (fieldLength > field.getAnnotation(MinMaxLength.class).maxLength()
                            || fieldLength < field.getAnnotation(MinMaxLength.class).minLength()) {
                        throw new IllegalArgumentException(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(e);
                }
            }

            // проверка пустого значения
            if (field.isAnnotationPresent(NotEmpty.class)) {
                Object fieldValue;
                field.setAccessible(true);
                try {
                    fieldValue = field.get(form);
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(e);
                }
                // в условиях задачи не указано для каких типов аннотации применимы, поэтому
                // делаем универсальную проверку на пустое значение
                if (fieldValue == null
                        || (fieldValue instanceof Number
                                && ((Number) fieldValue).doubleValue() == 0.0)
                        || (fieldValue instanceof String
                                && ((String) fieldValue).isEmpty())) {
                    throw new IllegalArgumentException(field.getName());
                }
            }

        }
    }
}
