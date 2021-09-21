package cons05threads.examples;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scanner=new Scanner(System.in);
      scanner.nextLine();


      Egg egg = new Egg();
      egg.start();

   }
}
