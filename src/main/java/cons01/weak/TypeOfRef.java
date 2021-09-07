package cons01.weak;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class TypeOfRef {
   public static void main(String[] args) {
      SoftReference<StringBuffer> sr= new SoftReference<>(new StringBuffer("мягкая ссылка"));
      WeakReference<StringBuffer> wr=new WeakReference<>(new StringBuffer("слабая ссылка"));

      System.out.println("мягкая: "+sr.get());
      System.out.println("слабая: "+wr.get());

      System.gc();

      System.out.println("после сборки мусора");
      System.out.println("мягкая: "+sr.get());
      System.out.println("слабая: "+wr.get());

   }
}
