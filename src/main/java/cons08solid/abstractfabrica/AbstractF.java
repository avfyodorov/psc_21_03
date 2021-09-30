package cons08solid.abstractfabrica;

/**
 *  1 еще один уровень абстракции
 *  2 клиент знает интефейсы продуктов и класс фабрики
 */
public class AbstractF {
   public static void main(String[] args) {

   }
}


interface Weapon{
   String getName();
}
interface Shield extends Weapon{
   String getMaterial();
}
interface Sword extends Weapon{
   String getHands();
}
//---------------
class ShieldImpl implements Shield{

   @Override
   public String getName() {
      return "Shield";
   }

   @Override
   public String getMaterial() {
      return null;
   }
}
//==================

interface WeaponFactory{
   default  Shield createShield(){
      return null;
   }
   default Sword createSword(){
      return null;
   }
}
//==================

class SmithShield implements Shield{
   @Override
   public String getName() {
      return "ЩИТ";
   }

   @Override
   public String getMaterial() {
      return "МЕТАЛЛ";
   }
}
class SmithSword implements Sword {

   @Override
   public String getName() {
      return "меч";
   }

   @Override
   public String getHands() {
      return "двуручный";
   }
}
enum SmithFactory implements WeaponFactory{
   INSTANCE;

   @Override
   public Shield createShield() {
      return new SmithShield();
   }

   @Override
   public Sword createSword() {
      return new SmithSword();
   }
}

enum AbstractFabrica{
   INSTANCE;

   Weapon getWeapon(String factory, String weapon){
      WeaponFactory weaponFactory = null;

      if (factory.equalsIgnoreCase("кузница"))
         weaponFactory=SmithFactory.INSTANCE;


      if (weaponFactory!=null){
         if (weapon.equalsIgnoreCase("шит"))
            return weaponFactory.createShield();
         else if (weapon.equalsIgnoreCase("меч"))
            weaponFactory.createSword();
      }
      return null;
   }

}