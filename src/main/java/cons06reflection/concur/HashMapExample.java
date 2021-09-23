package cons06reflection.concur;

import java.util.HashMap;
        import java.util.Iterator;
        import java.util.Map;
        import java.util.concurrent.ConcurrentHashMap;

public class HashMapExample
{
   Map<String, String> map;

   public HashMapExample()
   {
      System.out.println("ConcurrentHashMap");
      createMap(true);
      addValue ();

      System.out.println("\n\nHashMap");
      createMap(false);
      addValue ();
   }

   private void addValue()
   {
//вывести содержимое
      System.out.println("  before iterator : " + map);
      Iterator<String> it = map.keySet().iterator();

//в процессе перебора добавить эл-т
      System.out.print("  cycle : ");
      while(it.hasNext()){

         String key = it.next();
         if (key.equals("2")) {
            map.put(key + "new", "222");
         } else
            System.out.print("  " + key + "=" + map.get(key));
      }

//что получилось
      System.out.println();
      System.out.println("  after iterator : " + map);
   }

   /**
    * Метод createMap создает объект типа Map<String, String>.
    * В зависимости от параметра concurrent будет использован либо класс ConcurrentHashMap, либо HashMap.
    */
   private void createMap(boolean concurrent)
   {
      if (concurrent)
         map = new ConcurrentHashMap<String, String>();
      else
         map = new HashMap<String, String>();

      map.put("1", "1");
      map.put("2", "1");
      map.put("3", "1");
      map.put("4", "1");
      map.put("5", "1");
      map.put("6", "1");
   }

   public static void main(String[] args)
   {
      new HashMapExample();
   }
}

/**
 * Метод putIfAbsent (K, V) добавляет новую пару key-value только в том случае,
 * если в коллекции нет значения с данным ключом, и возвращает предыдущее значение для заданного ключа.
 *
 * Метод remove(K, V) удаляет пару key-value только в том случае,
 * если заданному ключу соответствует значение в коллекции Map, и возвращает true, если элемент был успешно удален.
 *
 * Метод replace(K, V, V) заменяет по ключу старое значение на новое только в том случае,
 * если старое значение соответствует заданному значению, и возвращает true, если значение было заменено на новое.
 *
 * Метод replace(K, V) заменяет по ключу старое значение на новое, и возвращает предыдущее значение для заданного ключа.
 */

