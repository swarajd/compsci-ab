// your name, date

/*****************************************
Demonstrates many ways to reverse a list made of ListNodes.
******************************************/

   import java.io.*;
   import java.util.*;

   public class ListLabReverse_shell
   {
      public static void main(String[] args)
      {
         ListNode head = new ListNode("hello", null);
         head = new ListNode("foo", head);
         head = new ListNode("boo", head);
         head = new ListNode("nonsense", head);
         head = new ListNode("computer",
            new ListNode("science",
            new ListNode("java",
            new ListNode("coffee", head))));
      
         System.out.print("original: \t\t");
         ListLab1.print(head);
      
         System.out.print("printReverse: \t");
         printReverse(head);
      
         System.out.println();
         System.out.print("original: \t\t");
         ListLab1.print(head);
      
         System.out.print("reverse with 2 pointers:");
         head = reverse(null, head);
         ListLab1.print(head);
      
         System.out.print("iterative reverse:\t");
         head = reverseIterate(head);
         ListLab1.print(head);
       
         System.out.print("reverse in place \t");
         head = reverseInPlace(head);
         ListLab1.print(head);
      
         System.out.print("reverse a linked list \t");
         head = reverseLL(head);
         ListLab1.print(head);
      
         System.out.print("Mind Bender reverse\t");
         head = mindBender(head);
         ListLab1.print(head);
      }
   /*********************************************
   These two methods don't reverse the list.  They only print out
   the list in reverse order.  printReverse() prints the square 
   brackets and calls helper().  helper() is recursive.
   ********************************************************/
      public static void printReverse(ListNode h)
      {
         System.out.print("        [");
         helper(h);
         System.out.print("]");
      }
      private static void helper(ListNode p)
      {
         if (p != null) 
         {
            helper(p.getNext());
            System.out.print(p.getValue() + ", ");
         }
      }
   
   /*********************************************
   This iterative method (for or while) produces a copy of the 
   reversed list.	 For each node going forward, make a new node and 
   link it to the list.	The list will naturally be in reverse. 
   ***********************************************************/
      public static ListNode reverseIterate(ListNode head)
      {
			if (head == null) {
				return null;
			}
         ListNode head_ = new ListNode(head.getValue(), head.getNext());
         head = new ListNode(head.getValue(), null);
         head_ = head_.getNext();
         while (head_ != null) 
         {
            head = new ListNode(head_.getValue(),head);
            head_ = head_.getNext();
         }
         return head;
      }
   
   /*******************************************
   This iterative method (while) uses 3 pointers to reverse 
   the list in place.   The two local pointers are called
   prev and next.
   ********************************************************/
      public static ListNode reverseInPlace(ListNode head)
      {
         if (head == null)
            return null;
         if (head.getNext() == null)
            return head;
      	
         ListNode prev = head.getNext();
         ListNode next = prev.getNext();
         prev.setNext(head);
         head.setNext(null);
         if (next == null)
            return prev;
      //ListNode cur = next1;
      //ListNode prev = prev1;
         while (next != null)
         {
            ListNode tmp = next.getNext();
            next.setNext(prev);
            prev = next;
            next = tmp;
         }
         head = prev;
         return head;
      }
   
   /**************************************************
   This method uses two pointers as arguments to reverse 
   the list in place. It is recursive.
   *********************************************************/
      public static ListNode reverse(ListNode prev, ListNode head)
      {
         if (head == null)
            return null;
         if (head.getNext() == null)
         {
            head.setNext(prev);
            return head;
         }
         ListNode r = reverse(head, head.getNext());
         head.setNext(prev);
         return r;
       
      } 
   /**********************************************
   Each time, do pointerToLast() and nextToLast(), and link (append())
   them together.  ReverseLL is recursive.
   ********************************************************/
      public static ListNode reverseLL(ListNode head)
      {
         if (head == null || head.getNext() == null)
         {
            return head;
         }
         ListNode rev = pointerToLast(head);
         nextToLast(head).setNext(null);
         append(rev,reverseLL(head));
         return rev;
      }
      private static ListNode pointerToLast(ListNode head)
      {
         ListNode head_ = new ListNode(head.getValue(),head.getNext());
         if (head_ != null)
         {
            while (head_.getNext().getNext() != null)
            {
               head_ = head_.getNext();
            }
            return head_.getNext();
         }
         else
         {
            return null;
         }
      }
      private static ListNode nextToLast(ListNode head)
      {
         while (!(head.getNext().equals(pointerToLast(head))))
         {
            if (head.getNext().equals(pointerToLast(head)))
               return head;
            else
               head = head.getNext();
         }
         return head;
      }
      private static ListNode append(ListNode h1, ListNode h2)
      {
         h1.setNext(h2);
         return h1;
      }
   /**********************************************
   This difficult method reverses the list in place, using one
   local pointer. Start with pointerToLast(). The helper method
   is recursive.
   ********************************************************/
      public static ListNode mindBender(ListNode head)
      {
			if (head == null || head.getNext() == null) {
				return head;
			}
         ListNode temp = pointerToLast(head);
         mindBenderHelper(head);
         head.setNext(null);
         return temp;
      }
      public static void mindBenderHelper(ListNode head)
      {
         if (head == null || head.getNext() == null)
         {
            return;
         }
         else
         {
            mindBenderHelper(head.getNext());
            ListNode tmp = head.getNext();
            head.setNext(null);
            tmp.setNext(head);
         }
      }
   }
