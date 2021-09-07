package cons01.weak;


public class WeakRef {
   public static void main(String[] args) {


      A a = new A();
      a.strong();

      B b = new B();

    a.weak(b);
   }
}

class A{
   void strong(){
      B b=new B();  //сильная зависимость
      ///...............
      b.b();
   }

   //внедрение зависимостей
   void weak(B b ){

      b.b();  // слабая зависимость
   }
}

class B{
   void b() {}
}
