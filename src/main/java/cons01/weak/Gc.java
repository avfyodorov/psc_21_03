package cons01.weak;

//модель памяти : стек и куча
//куча фрагментируется
//используемы объекты: ссылки из лок.пер-х, парам.методов, стат. перем., ссыли из стека

//молодое поколение - недавно появившиеся объекты
//выжившие - остались после сборки мусора
//старое поколение - пережившие несколько сбор.м.
//молодое живет недолго

//7 сборщиков мусора6 Serial, Parallel< CMS, G1, Epsilon, Z, Shenandoah
//4 типа ссылок
//
//SoftReference
//основное предназ - кэш
//когда память заканчивается - удаляет объект и все объекты доступные только через него

//WeakReference
//WeakHashMap основан на слабых ссылках
//предназначен для автоматич. удаления, если нет сильных ссылок на ключ

//PhantomReference
//обычные ссылки

//TypeOfRef.java
//WeakHash.java

//Внедрение зависимостей (DI) и инверсия управления (IoC) позволяют писать независимые
// друг от друга компоненты, что дает преимущества в командной разработке,
// переносимости модулей и т.д..

//WeakRef.java




//=======================
/*
import cons01.arraylist.Iterator;
import cons01.arraylist.List;package cons01.arraylist;

//Самостоятельно реализовать методы get/add/iterator для класса ArrayList.
//        Список должен иметь возможность "увеличивать" свой объем при переполнении.
//        PS. Учтите, что список может содержать как 1, так и 100500 элементов,
//        нет необходимости занимать лишнюю память под пустые ячейки.
//
//        PS. PS. не подглядывать никуда :)

public class ArrayList<E> implements List<E> {

   public static void main(String[] args) {
      List<String> list = new cons01.arraylist.ArrayList<>();

      list.add("A");
      list.add("B");
      list.add("D");
      list.add("J");
      list.add("C");
      list.add("P");

      Iterator<String> it1 = list.iterator();
      while (it1.hasNext())
         System.out.println(it1.next());

      ((cons01.arraylist.ArrayList<String>) list).print();

      System.out.println("==================");
      List<Integer> lint = new cons01.arraylist.ArrayList<>();
      for (int i = 0; i < 11; i++) {
         lint.add(i);
      }
      Iterator<Integer> it2 = lint.iterator();
      while (it2.hasNext())
         System.out.println(it2.next());

      ((cons01.arraylist.ArrayList<Integer>) lint).print();
   }

   //массив
   E[] arr;
   //
   int freePos;
   //начальный размер массива
   static final int SIZE = 2;
   //коэф. увеличения размера массива
   static final int ARISE = 2;

   public ArrayList() {
      arr = (E[]) new Object[SIZE];
      freePos = 0;
   }

   void resize() {
      //
      E[] temp = (E[]) new Object[arr.length * ARISE];

      for (int i = 0; i < arr.length; i++) {
         temp[i] = arr[i];
      }

      arr = temp;
      System.out.println("новый размер: " + arr.length);
   }

   void print() {
      String s = "[";
      for (int i = 0; i < freePos; i++) {
         s = s + arr[i] + ", ";
      }
      System.out.println(s + "]");
   }

   @Override
   public void add(E element) {
//проверить выход за границы
      if (freePos == arr.length)
         resize();

      arr[freePos++] = element;
   }

   @Override
   public E get(int index) {
      if (index < 0 || index >= arr.length)
         return null;

      return arr[index];
   }

   private class ArrayIterator implements Iterator<E> {

      int cur = 0;

      @Override
      public boolean hasNext() {
         return cur < freePos;
      }

      @Override
      public E next() {
         return arr[cur++];
      }
   }

   @Override
   public Iterator<E> iterator() {
      return new cons01.arraylist.ArrayList.ArrayIterator();
   }
}
*/
public class Gc {
   public static void main(String[] args) {
      //принудительный вызов  для очистки кеша, поиск утечек памяти, очистка после старта сервера
      System.gc();
   }
}
