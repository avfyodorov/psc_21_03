package cons05threads.txt;

import java.util.concurrent.atomic.AtomicInteger;

class Counter{
   private int cnt = 0;

   public  void inc() {
       cnt = cnt + 1;
   }
   public int getCnt(){ return cnt; }
}

class IncCount implements Runnable{
   Counter counter;

   public IncCount(Counter counter) {
      this.counter = counter;
   }

   @Override
   public  void run() {
      for (int i = 0; i < 1000; i++) {
         counter.inc();
      }
   }
}

public class Count1 {
   public static void main(String[] args) throws InterruptedException {
      Counter counter=new Counter();

      Thread t1 = new Thread(new IncCount(counter));
      Thread t2 = new Thread(new IncCount(counter));
      Thread t3 = new Thread(new IncCount(counter));

      t1.start();
      t2.start();
      t3.start();

      t1.join();
      t2.join();
      t3.join();

      System.out.println(counter.getCnt());
   }
}
