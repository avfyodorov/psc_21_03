package cons01;

public class Exampl03 {
}

abstract class Root{
   abstract int m1();
   abstract void m2();
   abstract String m3();
}

class A extends Root{

   @Override
   int m1() {      return 0;   }

   @Override
   void m2() {  }

   @Override
   String m3() {
      return null;
   }
}

class B extends A{
   @Override
   int m1() {      return 8;   }
}

interface IRoot{
    int m1();
    void m2();
    String m3();
}

class IA implements IRoot{

   @Override
   public int m1() {
      return 0;
   }

   @Override
   public void m2() {

   }

   @Override
   public String m3() {
      return null;
   }
}

class IB implements IRoot{

   @Override
   public int m1() {
      return 0;
   }

   @Override
   public void m2() {

   }

   @Override
   public String m3() {
      return null;
   }
}