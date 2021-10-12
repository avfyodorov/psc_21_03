package cons10view;
/*
import java.io.PrintWriter;
import java.sql.*;

public class CallSP {
   public static void main(String[] args) {


      try {
         Connection connection = null;
         int quantity = 99;
         String product = "product";
         CallableStatement proc = connection.prepareCall("{ call set_quantity( ?, ?) }");
         proc.setString(1, product);
         proc.setInt(2, quantity);
         proc.execute();
      } catch (
              SQLException e) {
         // ....
      }
   }


   static void printEmployees(PrintWriter out) {
      Connection con = null;
      CallableStatement stmt = null;

      try {
         con = ConnectionPool.getConnection();

         // для PostgreSQL сначала нужно создать транзакцию (AutoCommit == false)...
         con.setAutoCommit(false);

         // Настраиваем вызов.
          stmt = connection.prepareCall("{ ? = call list_employees () }");
         stmt.registerOutParameter(1, Types.OTHER);
         getResults.execute();

         ResultSet rs = (ResultSet) getResults.getObject(1);
         while (rs.next()) {
            String name = rs.getString(1);
            int age = rs.getInt(2);
            out.println(name + " was " + age + " years old.");
         }
         rs.close();
      } catch (SQLException e) {
         // Мы должны защитить эти вызовы.
         stmt.close();
         con.close();
      }
   }
}

   create procedure list_employeess () return refcursor as
        declare
        curr refcursor;
        begin
        open curr for
        SELECT name, age
        FROM employeess
        WHERE age > 60;
        return curr;
        end;
        ' language plpgsql';

*/