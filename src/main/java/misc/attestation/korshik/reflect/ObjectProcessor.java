package misc.attestation.korshik.reflect;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ObjectProcessor implements ReflectionProcessor {
   private Object object;
   private Class<?> objClass;

   public ObjectProcessor(Object object) {
      this.object = object;
      this.objClass = object.getClass();
   }

   public void process(Set<String> fieldsToCleanup, Set<String> fieldsToOutput) {
      HashMap<String, Field> fields = fieldArrayToMap(objClass);

      checkFieldAvailability(fields, fieldsToCleanup);
      checkFieldAvailability(fields, fieldsToOutput);

         setDefaults(fields, fieldsToCleanup);
         printValues(fields, fieldsToOutput);
   }

   /**
    * Задаёт указанным в <code>fieldsToCleanup</code> полям дефолтные значения
    *
    * @param objFields       все поля класса
    * @param fieldsToCleanup список полей для обнуления
    */
   private void setDefaults(Map<String, Field> objFields, Set<String> fieldsToCleanup) {
      for (String fieldName : fieldsToCleanup) {
         Field fieldsInObject = objFields.get(fieldName);
         Object defaultValue = CleanerPrinter.getDefaultValue(fieldsInObject.getType());
         fieldsInObject.setAccessible(true);
         try {
            fieldsInObject.set(object, defaultValue);
         } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
         }
      }
   }

   /**
    * Печатает значение всех полей из <code>object</code>, указанных в <code>fieldsToOutput</code>
    *
    * @param objFields      все поля из класса
    * @param fieldsToOutput какие поля выводить
    */
   private void printValues(Map<String, Field> objFields, Set<String> fieldsToOutput) {
      for (String fieldName : fieldsToOutput) {
         Field field = objFields.get(fieldName);
         field.setAccessible(true);
         try {
            Object fieldValue = field.get(object);
            if (fieldValue != null) {
               System.out.println(CleanerPrinter.valueToString(fieldValue));
            }
         } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
         }
      }
   }


   /**
    * Преобразует массив полей из класса <code>objClass</code> в HashMap для последующего поиска
    *
    * @param objClass в каком классе берём массив полей
    * @return <code>Map</code> с ключом в виде имени поля и значением в виде самого поля
    */
   private HashMap<String, Field> fieldArrayToMap(Class<?> objClass) {
      Field[] fields = objClass.getDeclaredFields();
      HashMap<String, Field> result = new HashMap<>();

      for (Field field : fields) {
         result.put(field.getName(), field);
      }

      return result;
   }

   /**
    * Проверяет в обрабатываемом объекте наличие полей, к которым будут обращаться
    *
    * @param objFields     список полей, объявленных в классе
    * @param fieldsToCheck множество полей, которые должны быть в классе
    */
   private void checkFieldAvailability(Map<String, Field> objFields, Set<String> fieldsToCheck) {
      for (String field : fieldsToCheck) {
         if (!objFields.containsKey(field)) {
            throw new IllegalArgumentException("В классе '" + objClass.getName() + "' нет поля '" + field + "'!");
         }
      }
   }

}
