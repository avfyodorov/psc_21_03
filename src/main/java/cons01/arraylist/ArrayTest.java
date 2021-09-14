package cons01.arraylist;

import java.util.Arrays;
import java.util.Objects;

public class ArrayTest {
   public static void main(String[] args) {
      Integer[] arr = {1,2,3};
//      Objects.checkIndex();
      arr= Arrays.copyOf(arr, 6);
      System.out.println(arr.length+" "+arr[2]);
   }
}
