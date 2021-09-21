package cons05threads.misc;

public class AppRun {
   public static void main(String[] args) throws InterruptedException {
      int n = 99;

      Thread thread=new Thread(() ->
      {
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         System.out.println("thread run : " + n);
      });

      thread.start();
thread.join();
      System.out.println("main run");
   }
}
