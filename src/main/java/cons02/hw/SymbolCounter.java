package cons02.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SymbolCounter {
   public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter string: ");
      String line = scanner.nextLine();

      Map<Character, Integer> counter = new HashMap<>();
      char currentChar;

      for (int i = 0; i < line.length(); i++) {
         //counter.merge(line.charAt(i), 1, Integer::sum);
         // ниже вариант "вручную", с работой с элементами HashMap
         currentChar = line.charAt(i);
         if (counter.containsKey(currentChar)) {
            counter.put(currentChar, counter.get(currentChar) + 1);
         } else {
            counter.put(currentChar, 1);
         }
      }

      // System.out.println(counter);
      for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
         System.out.println(entry.getKey() + " - " + entry.getValue());
      }

   }
}


