package cons05threads.examples;

public class Egg extends Thread{
   @Override
   public void run() {
      for (int i = 0; i < 1000; i++) {
         try {
            Thread.sleep(300);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         System.out.println(Thread.currentThread().getName());
      }
   }
   }
