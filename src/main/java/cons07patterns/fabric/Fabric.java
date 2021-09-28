package cons07patterns.fabric;

interface Polygon {
   public String getInfo();
}

class Triangle implements Polygon {
   private double a, b, c;
   public Triangle(double a, double b, double c) {
      this.a = a;
      this.b = b;
      this.c = c;
   }
   @Override
   public String getInfo() {
      return "Треугольник со сторонами: " + a + ", " + b + ", " + c;
   }
}

class Tetragon implements Polygon {
   private double a, b, c, d;
   public Tetragon(double a, double b, double c, double d) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.d = d;
   }
   @Override
   public String getInfo() {
      return "Четырёхугольник со сторонами: " + a + ", " + b + ", " + c + ", " + d;
   }
}

class Pentagon implements Polygon {
   private double a, b, c, d, e;
   public Pentagon(double a, double b, double c, double d, double e) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.d = d;
      this.e = e;
   }
   @Override
   public String getInfo() {
      return "Пятиугольник со сторонами: " + a + ", " + b + ", " + c + ", " + d + ", " + e;
   }
}

class PolygonFactory {
   public Polygon createPolygon(double... sizes) {
      switch (sizes.length) {
         case 3: return new Triangle(sizes[0], sizes[1], sizes[2]);
         case 4: return new Tetragon(sizes[0], sizes[1], sizes[2], sizes[3]);
         case 5: return new Pentagon(sizes[0], sizes[1], sizes[2], sizes[3], sizes[4]);
      }
      return null;
   }
}

public class Fabric {
   public static void main(String[] args) {
      PolygonFactory factory = new PolygonFactory();
      Polygon poly1 = factory.createPolygon(3, 4, 5);
      Polygon poly2 = factory.createPolygon(4, 5, 4, 5);
      Polygon poly3 = factory.createPolygon(1, 2, 3, 4, 5);
      System.out.println(poly1.getInfo());
      System.out.println(poly2.getInfo());
      System.out.println(poly3.getInfo());
   }
}
