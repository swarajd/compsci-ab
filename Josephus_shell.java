// name:             date:

   import java.io.*;
   import java.util.Scanner;
   import javax.swing.JOptionPane;
	
    public class Josephus_shell
   {
       public static void main(String[] args) throws FileNotFoundException
      {
		  //Scanner kb = new Scanner(System.in);
		  ListNode list = new ListNode(1,null);
		  list.setNext(list);
		  for (int i = 1; i < 10; i++)
		  {
			  insert(list,i);
		  }
		  for (int i = 0; i < 5; i++)
		  {
			  print(list);
			  remove(list,5);
		  }
          System.exit(0);
      }
		
      /* removes the node p after counting n nodes.
		  */      
       private static ListNode remove(ListNode p, int n)
      {
		  for (int i = 0; i < n-1; i++)
		  {
			  p = p.getNext();
		  }
		  p.setNext(p.getNext().getNext());
		  return p;
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
			 p = p.getNext();
			 while (!(p.equals(temp)))
			 {
				 System.out.print(p.getValue() + ", ");
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
         
      }
   }
