import java.io.*;
import java.util.*;

public class LListTester {
   public static void OddEven(LList aList, Integer val) {
      if (val % 2 == 0) {
         aList.addFirst(val);
      } 
      else {
         aList.addLast(val);
      }
   }
   public static void main(String[] args) {
      LList someList = new LList();
      Scanner kb = new Scanner(System.in);
             
      System.out.print("enter a number, negative to quit: ");
      int addint = kb.nextInt();
      while (addint >= 0) {
         OddEven(someList,addint);
         System.out.print("enter a number, negative to quit: ");
         addint = kb.nextInt();
      }
      someList.printWhile();
      System.out.println();
      someList.printFor();
             
   }
}
