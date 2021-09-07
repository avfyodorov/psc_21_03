package cons01.weak;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class WeakHash {
   public static void main(String[] args) {
      WeakHashMap<String, String> files = new WeakHashMap<>();

      List<String> fileNames = new ArrayList<>();
      for (int i = 0; i < 3; i++) {
         fileNames.add("file " + i);
      }

      for (int i = 0; i < 3; i++) {
         files.put(fileNames.get(i), "file " + i);
      }

      for (int i = 0; i < 3; i++) {
         System.out.println(files.get(fileNames.get(i)));
      }

      fileNames.remove(2);
      fileNames.remove(0);

      System.gc();

      System.out.println("После сборки");
      for (int i = 0; i < 3; i++) {
         System.out.println(files.get("file " + i));
      }

   }
}
