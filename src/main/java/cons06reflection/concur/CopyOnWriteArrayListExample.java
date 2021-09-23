package cons06reflection.concur;

import java.util.List;
        import java.util.Iterator;
        import java.util.ArrayList;
        import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample
{
   List<String> list;
   public CopyOnWriteArrayListExample()
   {
      List<String> lst = new ArrayList<String>();
      lst.add("Java");
      lst.add("J2EE");
      lst.add("J2SE");
      lst.add("Collection");
      lst.add("Concurrent");

      //создается потокобезопасная коллекция
      list = new CopyOnWriteArrayList<String>(lst);

      System.out.println("ЦИКЛ с изменением");
      printCollection(true);
      System.out.println("\nЦИКЛ без изменением");
      printCollection(false);
   }

   private void printCollection(boolean change)
   {
      Iterator<String> iterator = list.iterator();
      while(iterator.hasNext()){
         String element = iterator.next();
         System.out.printf("  %s %n", element);

 //добавить новый, удалить старый
         if (change) {
            if (element.equals("Collection")) {
               list.add("Новая строка");
               list.remove(element);
            }
         }
      }
   }

   public static void main(String args[])
   {
      new CopyOnWriteArrayListExample();
   }
}

