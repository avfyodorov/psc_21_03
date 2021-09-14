package cons02.hw;

import java.util.HashMap;
import java.util.Map;

public class Password {
   public static void main(String[] args) {//throws BadPasswordException, BadEmailException {
//      UsersService myService = new MyUserService();

      Map<String, String> singUpTestInfo = new HashMap<>();
      singUpTestInfo.put("en.builin@gmail.com", "abcd1234"); // ok
      singUpTestInfo.put("mail@gmail.com", "abcd1234"); // ok
      singUpTestInfo.put("en.builingmail.com", "abcd1234"); // wrong email
      singUpTestInfo.put("en.builin2@gmail.com", "abcd123"); // wrong pwd
      singUpTestInfo.put("en.builin3@gmail.com", "12345678"); // wrong pwd
      singUpTestInfo.put("en.builin4@gmail.com", "abcdefghij"); // wrong pwd
      singUpTestInfo.put("en.builin5gmail.com", "%$#%@#$%@#$%@"); // everything wrong

      for (Map.Entry<String, String> entry : singUpTestInfo.entrySet()) {
         System.out.print(entry.getKey() + ": " + entry.getValue() + " -> ");
         try {
//            myService.signUp(entry.getKey(), entry.getValue());
            checkPassword( entry.getValue());
            System.out.println("Успешно зарегистрирован!");
         } catch (BadPasswordException | BadEmailException e) {
            System.out.println(e.getMessage());
            System.out.println(e);
         }
      }
   }

   static void checkPassword(String password) throws BadPasswordException,BadEmailException {

      char[] chars = password.toCharArray();
      boolean pwdHaveLetters = false, pwdHaveNumbers = false;

      for (char c : chars) {
         if (Character.isLetter(c)) {
            pwdHaveLetters = true;
         } else if (Character.isDigit(c)) {
            pwdHaveNumbers = true;
         } else {
            System.out.println("внутри");
            throw new BadPasswordException("vvvvvvvvvvvПароль должен состоять из букв и цифр");
         }
      }
      if (!(pwdHaveLetters && pwdHaveNumbers)) {
         System.out.println("снаружи");
         throw new BadPasswordException("Пароль должен состоять из букв и цифр");
      }

   }
}

class BadEmailException extends Exception {
   public BadEmailException() {
      super("Неверный формат почты!");
   }

   public BadEmailException(String message) {
      super("Неверный формат почты: " + message);
   }
}

class BadPasswordException extends Exception{
   public BadPasswordException() {
      super("Неверный пароль!");
   }

   public BadPasswordException(String message) {
      super("Неверный пароль: " + message);
   }
}