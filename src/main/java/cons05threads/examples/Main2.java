package cons05threads.examples;

public class Main2 {
   public static void main(String[] args) {
      Runnable runnable=()-> {
            for (int i = 0; i < 100000; i++) {
               System.out.println("zzz");
            }
      };

      Thread thread=new Thread(runnable);
      thread.start();
   }
}
