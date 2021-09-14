package cons02.hw;

public class CheckPsw {
   static boolean checkPassword(String password) {
      return password.length() > 7 && password.matches("[a-zA-Z0-9]+");

   }

   public static void main(String[] args) {
      System.out.println(checkPassword( "abcd1234")); // ok
      System.out.println(checkPassword( "1234567890")); // ok
   }
}
