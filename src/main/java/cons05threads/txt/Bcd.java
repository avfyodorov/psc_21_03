package cons05threads.txt;

class MyThread implements Runnable{
   private Stopper stopper;

   public MyThread(Stopper stopper) {
      this.stopper = stopper;
   }

   @Override
   public void run() {
      while (!stopper.isStop())
         System.out.println("running..."+Thread.currentThread().getName());
   }
}
class Stopper {
   private boolean stop = false;

   public boolean isStop() {
      return stop;
   }

   public void setStop() {
      stop = true;
   }
}

public class Bcd {
   public static void main(String[] args) throws InterruptedException {
      Stopper stopper=new Stopper();

      Thread t1=new Thread(new MyThread(stopper));
      Thread t2=new Thread(new MyThread(stopper));
      Thread t3=new Thread(new MyThread(stopper));

      t1.start();
      t2.start();
      t3.start();

      Thread.sleep(500);

      stopper.setStop();
   }
}
