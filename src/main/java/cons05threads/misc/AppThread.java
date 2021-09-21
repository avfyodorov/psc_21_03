package cons05threads.misc;

public class AppThread {
   public static void main(String[] args) {
      Thread thread = new MyThread(5);
      thread.start();
//убедиться, что другой поток
      System.out.println(Thread.currentThread().getName());
   }
}

class MyThread extends Thread {
   int n;

   public MyThread(int n) {
      this.n = n;
   }

   @Override
   public void run() {
      System.out.println(Thread.currentThread().getName()+" :"+n);
   }
}

/**
 * Метод run() –определяет логику, которая будет выполнена в
 * отдельном потоке.
 * Метод start() –запускает метод run в отдельном потоке.
 * Если запустить вместо метода start() метод run(), то код
 * метода run() будет выполнен в main потоке
 */

/**
 * Состояния потока
 * New -новый поток начинает свой жизненный цикл в новом
 * состоянии. Он остается в этом состоянии, пока программа не
 * запустит поток.
 *
 * .start() -> .run()
 * Runnable -после запуска только что созданного потока поток
 * становится работоспособным. Поток в этом состоянии
 * считается выполняющим свою задачу.
 *
 * .sleep()   .wait()
 * Waiting -иногда поток переходит в состояние ожидания, пока
 * поток ожидает, пока другой поток выполнит задачу. Поток
 * возвращается в состояние выполнения только тогда, когда
 * другой поток сигнализирует ожидающему потоку о
 * продолжении выполнения.
 *
 * Timed Waiting -работающий поток может войти в состояние
 * ожидания по времени в течение определенного интервала
 * времени. Поток в этом состоянии возвращается в
 * работоспособное состояние, когда истекает этот временной
 * интервал или когда происходит ожидаемое событие.интервал или когда происходит ожидаемое событие.
 *
 *
 * Dead (завершено) -работающий поток входит в завершенное
 * состояние, когда он завершает свою задачу или иным образом
 * завершает свою работу.
 */

/**
 * Родительский поток может проверить состояние дочернего
 * потока. Для этого используется метод isAlive()
 * Thread thread = new Thread(new MyThread());
 * thread.start();
 * if (thread.isAlive()) {if (thread.isAlive()) {
 * ........
 */

/**
 * Прерывание потока
 * Прервать поток можно с помощью метода interrupt().
 * На самом деле метод interrupt не прерывает поток, а только
 * выставляет флаг потоку, что нужно сделать прерывание. Сам
 * поток решает нужно ли ему прервать свою работу и где.поток решает нужно ли ему прервать свою работу и где.
 * Когда для потока вызывается метод interrupt() –у потока
 * изменяется флаг interrupted –с false на true
 *
 * разница между isIntrrupted и interrupted
 * исключения
 */