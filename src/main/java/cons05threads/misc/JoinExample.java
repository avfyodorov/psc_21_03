package cons05threads.misc;

import java.util.Calendar;

public class JoinExample {

   public static void main(String[] args) {
      Thread threadExample = new Thread(new JoinClass());
      threadExample.start();
      try {
         threadExample.join(); //public static void TestClass.main() connect to threadExample and wait for it.
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println("END: " + Calendar.getInstance().getTime());
   }
}

 class JoinClass implements Runnable {

   @Override
   public void run() {
      System.out.println("JoinClass.run() " + Calendar.getInstance().getTime());
      try {
         Thread.sleep(5000L);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.out.println("afterSleep " + Calendar.getInstance().getTime());
   }
}
/*
//Вывод
JoinClass.run() Tue Jan 19 00:00:37 MSK 2016
        afterSleep Tue Jan 19 00:00:42 MSK 2016
        END: Tue Jan 19 00:00:42 MSK 2016
        n
 */