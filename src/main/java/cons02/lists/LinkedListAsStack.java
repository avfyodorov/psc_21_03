package cons02.lists;

import java.util.LinkedList;

//   Специфические методы LinkedList
//        Метод Действие
//        void push(E e) Вставить элемент в начало списка
//        E poll() Взять первый элемент и удалить его из списка (если элементов в списке нет, то возвращает null)
//        E pollLast() Взять последний элемент и удалить его из списка (если элементов в списке нет, то возвращает null)
//        E removeFirst() Аналог pool, но если элементов в списке нет, то будет брошено исключение NoSuchElementException
//        E removeLast() Аналог poolLast, но если элементов в списке нет, то будет брошено исключение NoSuchElementException

//        LinkedList в качестве стека
public class LinkedListAsStack {
   public static void main(String args[]) {
      LinkedList<Integer> stack = new LinkedList();

      for (int i = 1; i <= 5; i++) {
         System.out.println("Помещаем в стек " + i);
         stack.push(i);
      }
      Integer current = stack.poll();
      while (current != null) {
         System.out.println("Взяли из стека " + current);
         current = stack.poll();
      }
   }
}