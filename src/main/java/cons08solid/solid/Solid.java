package cons08solid.solid;

public class Solid {
}
public class OrderProcessor {

   public void process(Order order){
      if (order.isValid() && save(order)) {
         sendConfirmationEmail(order);
      }
   }

   private boolean save(Order order) {
      MySqlConnection connection = new MySqlConnection("database.url");
      // сохраняем заказ в базу данных

      return true;
   }

   private void sendConfirmationEmail(Order order) {
      String name = order.getCustomerName();
      String email = order.getCustomerEmail();

      // Шлем письмо клиенту
   }
}
//--------------------
public class MySQLOrderRepository {
   public boolean save(Order order) {
      MySqlConnection connection = new MySqlConnection("database.url");
      // сохраняем заказ в базу данных

      return true;
   }
}

public class ConfirmationEmailSender {
   public void sendConfirmationEmail(Order order) {
      String name = order.getCustomerName();
      String email = order.getCustomerEmail();

      // Шлем письмо клиенту
   }
}

public class OrderProcessor {
   public void process(Order order){

      MySQLOrderRepository repository = new MySQLOrderRepository();
      ConfirmationEmailSender mailSender = new ConfirmationEmailSender();

      if (order.isValid() && repository.save(order)) {
         mailSender.sendConfirmationEmail(order);
      }
   }

}
//======================
//=======================
//=====================

public class OrderProcessorWithPreAndPostProcessing extends OrderProcessor {

   @Override
   public void process(Order order) {
      beforeProcessing();
      super.process(order);
      afterProcessing();
   }

   private void beforeProcessing() {
      // Осуществим некоторые действия перед обработкой заказа
   }

   private void afterProcessing() {
      // Осуществим некоторые действия после обработки заказа
   }
}
//==================
//==================
//==================

public class OrderStockValidator {

   public boolean isValid(Order order) {
      for (Item item : order.getItems()) {
         if (! item.isInStock()) {
            return false;
         }
      }

      return true;
   }
}

public class OrderStockAndPackValidator extends OrderStockValidator {

   @Override
   public boolean isValid(Order order) {
      for (Item item : order.getItems()) {
         if ( !item.isInStock() || !item.isPacked() ){
            throw new IllegalStateException(
                    String.format("Order %d is not valid!", order.getId())
            );
         }
      }

      return true;
   }
}
//========================
//========================
//========================

public class OrderProcessor {
   public void process(Order order){

      MySQLOrderRepository repository = new MySQLOrderRepository();
      ConfirmationEmailSender mailSender = new ConfirmationEmailSender();

      if (order.isValid() && repository.save(order)) {
         mailSender.sendConfirmationEmail(order);
      }
   }

}

public class MySQLOrderRepository {
   public boolean save(Order order) {
      MySqlConnection connection = new MySqlConnection("database.url");
      // сохраняем заказ в базу данных

      return true;
   }
}

public class ConfirmationEmailSender {
   public void sendConfirmationEmail(Order order) {
      String name = order.getCustomerName();
      String email = order.getCustomerEmail();

      // Шлем письмо клиенту
   }
}

public interface MailSender {
   void sendConfirmationEmail(Order order);
}

public interface OrderRepository {
   boolean save(Order order);
}

public class ConfirmationEmailSender implements MailSender {

   @Override
   public void sendConfirmationEmail(Order order) {
      String name = order.getCustomerName();
      String email = order.getCustomerEmail();

      // Шлем письмо клиенту
   }

}

public class MySQLOrderRepository implements OrderRepository {

   @Override
   public boolean save(Order order) {
      MySqlConnection connection = new MySqlConnection("database.url");
      // сохраняем заказ в базу данных

      return true;
   }
}

public class OrderProcessor {

   private MailSender mailSender;
   private OrderRepository repository;

   public OrderProcessor(MailSender mailSender, OrderRepository repository) {
      this.mailSender = mailSender;
      this.repository = repository;
   }

   public void process(Order order){
      if (order.isValid() && repository.save(order)) {
         mailSender.sendConfirmationEmail(order);
      }
   }
}