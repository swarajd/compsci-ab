// name:             date:



//                               __           __     __           __ __   __                                                               ___                     __                    ___
//.--.--.--.--.--.--.--.--.--.  |  |--.-----.|  |--.|__|.-----.--|  |  |_|  |--.-----.-----.---.-.--------.-----.  .----.-----.--------.  /  /.----.---.-.-----.--|  |.-----.--------.  /  /
//|  |  |  |  |  |  |  |  |  |__|  _  |  -__||     ||  ||     |  _  |   _|     |  -__|     |  _  |        |  -__|__|  __|  _  |        |,' ,' |   _|  _  |     |  _  ||  _  |        |,' ,' 
//|________|________|________|__|_____|_____||__|__||__||__|__|_____|____|__|__|_____|__|__|___._|__|__|__|_____|__|____|_____|__|__|__/__/   |__| |___._|__|__|_____||_____|__|__|__/__/   
                                                                                                                                                                                          



   import java.io.*;
   import java.util.Scanner;
   import javax.swing.JOptionPane;
	
   public class Josephus_shell
   {
      public static void main(String[] args) throws FileNotFoundException
      {
         Scanner kb = new Scanner(System.in);
         System.out.print("Enter the number of names: ");
         int nameNum = kb.nextInt();
         System.out.print("Enter the N: ");
         int N = kb.nextInt();
         ListNode list_i = new ListNode(1,null);
         ListNode list_n = new ListNode("Bob", null);
         list_i.setNext(list_i);
         list_n.setNext(list_n);
         String[] names = {"Imran", "Joseph", "Filip", "KazimÃ­r", "Ã‰tienne", "swagraj", "Hamza", "Neven", "Tryggvi"};
         if (nameNum > 0) {
            for (int i = 2; i <= nameNum; i++)
            {
               insert(list_i,i);
               insert(list_n,names[i-1]);
            }
            if (N > 0) {
              
               for (int i = 0; i < nameNum-1; i++)
               {
                  print(list_i);
                  list_i = remove(list_i,N);
               }
               print(list_i);
               replaceAt(list_n, "josephus", Integer.parseInt(list_i.getValue().toString()));
               for (int i = 0; i < nameNum-1; i++)
               {
                  print(list_n);
                  list_n = remove(list_n,N);
               }
               print(list_n);
            } 
            else {
               System.out.println("no one killed, everyone wins");
               print(list_n);
            }
         } 
         else {
            System.out.println("no people, no winner");
            System.out.println("[]");
         }
        
         System.exit(0);
      }
   	
      /* removes the node p after counting n nodes.
   	  */      
      private static ListNode remove(ListNode p, int n)
      {
         if (n == 1) 
         {
            ListNode temp = p;
            p = p.getNext();
            while (!(p.getNext().equals(temp)))
            {
               p = p.getNext();
            }
            p.setNext(p.getNext().getNext());
            return p.getNext();
         }
         for (int i = 0; i < n-2; i++)
         {
            p = p.getNext();
         }
         p.setNext(p.getNext().getNext());
         return p.getNext();
      }
   	
      /* prints the circular linked list.
   	  */      
      public static void print(ListNode p)
      {
         if(p == null)
         {
            System.out.println("[]");
            return;
         }
         else
         {
            System.out.print("[");
            ListNode temp = p;
            System.out.print(p.getValue() + ", ");
            p = p.getNext();
            while (!(p.equals(temp)))
            {
               if (!(p.getNext().equals(temp)))
                  System.out.print(p.getValue() + ", ");
               else
                  System.out.print(p.getValue());
               p = p.getNext();
            }
            System.out.println("]");
         }
      	
      }
   	
    /* helper method to build the list.  Creates the node, then
       inserts it in the circular linked list.
   	 */  
      private static ListNode insert(ListNode p, Object obj)
      {
         ListNode init = p;
         while (!(p.getNext().equals(init)))
         {
            p = p.getNext();
         }
         ListNode n = new ListNode(obj,init);
         p.setNext(n);
         return init;
      }
   
   	
   	/* replaces the value (the string) at the winning node.
          */	
      private static void replaceAt(ListNode p, Object obj, int pos)
      {
         for (int i = 0; i < pos-1; i++)
         {
            p = p.getNext();
         }
         p.setValue(obj);
      }
   }
