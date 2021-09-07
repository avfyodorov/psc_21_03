package cons01.arraylist;

//Самостоятельно реализовать методы get/add/iterator для класса ArrayList.
//        Список должен иметь возможность "увеличивать" свой объем при переполнении.
//        PS. Учтите, что список может содержать как 1, так и 100500 элементов,
//        нет необходимости занимать лишнюю память под пустые ячейки.
//
//        PS. PS. не подглядывать никуда :)

public class ArrayList<E> implements List<E> {

   public static void main(String[] args) {
      List<String> list = new ArrayList<>();

      list.add("A");
      list.add("B");
      list.add("D");
      list.add("J");
      list.add("C");
      list.add("P");

      Iterator<String> it1 = list.iterator();
      while (it1.hasNext())
         System.out.println(it1.next());

      ((ArrayList<String>) list).print();

      System.out.println("==================");
      List<Integer> lint = new ArrayList<>();
      for (int i = 0; i < 11; i++) {
         lint.add(i);
      }
      Iterator<Integer> it2 = lint.iterator();
      while (it2.hasNext())
         System.out.println(it2.next());

      ((ArrayList<Integer>) lint).print();
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
      return new ArrayIterator();
   }
}
