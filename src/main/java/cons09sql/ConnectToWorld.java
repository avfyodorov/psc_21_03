package cons09sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToWorld {

   static final String URL = "jdbc:mysql://localhost/world?serverTimezone=Europe/Moscow&";
   static final String USER = "user=root&";
   static final String password = "password=12345";

   public static void main(String[] args) throws ClassNotFoundException {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("ok");
      try (Connection conn = DriverManager.getConnection(URL)) {

      } catch (SQLException throwables) {
         throwables.printStackTrace();
      }

   }
}

/**
 * Метод Optional.map задуман как подспорье для упрощения потокового кода.
 * Подход на основе пары операций filter/map, безусловно, интуитивно более по-
 * нятен, особенно для разработчиков, непривычных к операциям flatMap, но ре-
 * зультат получается одинаковым.
 * Разумеется, вы вправе передать методу Optional.map любую функцию. В офи-
 * циальной документации демонстрируется преобразование имен файлов в по-
 * токи ввода. Еще один пример приведен в рецепте 6.4.
 * Кстати говоря, в Java 9 в класс Optional добавлен метод stream. Если Optional
 * не пуст, то этот метод возвращает одноэлементный поток, обертывающий на-
 * ходящееся внутри значение, в противном случае возвращается пустой поток.
 * Детали см. в рецепте 10.6.
 */