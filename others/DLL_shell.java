    public class DLL_shell
   {
       public static void main(String args[])
      {
         DLL list = new DLL();	
      
         list.addLast("Apple");
         list.addLast("Banana");
         list.addLast("Cucumber");
         list.addLast("Dumpling");
         list.addLast("Escargot");
         System.out.println(list);
         System.out.println(list.size());
         Object obj = list.remove(3);
         System.out.println(list);
         System.out.println(list.size());
         System.out.println("Removed "+ obj);
         System.out.print("Add at 3:   ");
         list.add(3,"Cheese");
         System.out.println(list);
         System.out.print("Add first:  ");
         list.addFirst("Anchovie");
         System.out.println(list);
         System.out.println(list.size());
      }
   }

//////////////////////////////////////////////////////////
    
    class DLL        //DoubleLinkedList
   {
      private int size;
      private DLNode head = new DLNode(); //dummy node--very useful--simplifies the code
   
       public int size()
      {
         return size;
      }
    	/* appends obj to end of list; increases size;
   	  @return true  */
       public boolean add(Object obj)
      {
         addLast(obj);
         return true;
      }
      /* inserts obj at position index.  increments size. 
   		*/
       public void add(int index, Object obj)
      {
         if(obj != null)
         {
            size++;
         }
         if(head == null)
         {
            DLNode temp = new DLNode();
            temp.setValue(obj);
         }
         else
         {
            DLNode temp = head;
            int i = 0;
            while(i < index)
            {
               temp = temp.getNext();
               i++;
            }
            DLNode next = new DLNode(obj, temp, temp.getNext());
            next.getNext().setPrev(next);
            temp.setNext(next);
         }
      }
      /* return obj at position index.  
   		*/
       public Object get(int index)
      {
         if(head == null)
         {
            return head;
         }
         else
         {
            DLNode temp = head;
            for(int i = 0; i < index; i++)
            {
               temp = temp.getNext();
            }
            return temp.getValue();
         }
      }
    /* replaces obj at position index.  
   		*/
       public void set(int index, Object obj)
      {
         if(head == null || head.getNext().equals(head))
         {
            head.setValue(obj);
            return;
         }
         DLNode temp = head;
         int i = 0;
         while(i < index)
         {
            temp = temp.getNext();
         }
         DLNode a = new DLNode(obj, temp.getPrev(), temp);
         temp.getPrev().setNext(a);
         temp.setPrev(a);
      }
    /*  removes the node from position index.  decrements size.
   	  @return the object at position index.
   	 */
       public Object remove(int index)
      {
         if(head == null || head.getNext().equals(head))
         {
            DLNode temp = new DLNode();
            Object a = head.getValue();
            head = temp;
            size = 0;
            return a;
         }
         DLNode temp = head;
         for (int i= 0; i <= index; i++)
         {
            temp = temp.getNext();
         }
         Object a = temp.getValue();
         temp.getPrev().setNext(temp.getNext());
         temp.getNext().setPrev(temp.getPrev());
         size--;
         return a;
      }
    /* inserts obj at front of list; increases size;
   	  */
       public void addFirst(Object obj)
      {
         if(obj != null)
         {
            size++;
         }
         if(head == null)
         {
            head = new DLNode();
            head.setValue(obj);
         }
         else
         {
            DLNode temp = new DLNode(obj, head.getPrev(), head);
            head.getPrev().setNext(temp);        
            head.setPrev(temp);
            head = temp;	
         }     
      }
   	/* appends obj to end of list; increases size;
   	    */
       public void addLast(Object obj)
      {
         if(obj != null)
         {
            size++;
         }
         if(head == null)
         {
            head = new DLNode();
            head.setValue(obj);
         }
         else if(head.getNext().equals(head))
         {
            DLNode temp = new DLNode(obj, head, head);
            head.setNext(temp);
            head.setPrev(temp);
         }
         else
         {
            DLNode temp = new DLNode(obj, head.getPrev(), head);
            head.getPrev().setNext(temp);
            head.setPrev(temp);
         }
      }
       public Object getFirst()
      {
         if(head == null)
         {
            return head;
         }
         return head.getValue();
      }
       public Object getLast()
      {
         if(head == null || head.getNext().equals(head))
         {
            return head;
         }
         return head.getPrev().getValue();
      }
       public Object removeFirst()
      {
         if(head == null || head.getNext().equals(head))
         {
            DLNode temp = new DLNode();
            Object a = head.getValue();
            head = temp;
            size = 0;
            return a;
         }
         head.getPrev().setNext(head.getNext());
         head = head.getNext();
         size--;
         return head.getValue();
      }
       public Object removeLast()
      {
         if(head == null || head.getNext().equals(head))
         {
            DLNode temp = new DLNode();
            Object a = head.getValue();
            head = temp;
            size = 0;
            return a;
         }
         head.getPrev().getPrev().setNext(head);
         size--;
         return head.getPrev().getValue();
      }
       public String toString()
      {
         if(head == null)
         {
            return "[]";
         }
         else if(head.getNext().equals(head))
         {
            return "[" + head.getValue().toString() + "]";
         }
         else
         {
            DLNode temp = head.getNext();
            String x = "[";
            while(!temp.equals(head))
            {
               x += temp.getValue() + ", ";
               temp = temp.getNext();
            }
            return x.substring(0, x.length()-2) + "]";
         }
      }
   }
	
	///////////////////////////////////////

	  
    class DLNode 
   {
      private Object value;
      private DLNode prev;
      private DLNode next;
       public DLNode(Object arg, DLNode p, DLNode n)
      {
         value=arg;
         prev=p;
         next=n;
      }
       public DLNode()
      {
         value=null;
         next=this;
         prev=this;
      }
       public void setValue(Object arg)
      {
         value=arg;
      }
       public void setNext(DLNode arg)
      {
         next=arg;
      }
       public void setPrev(DLNode arg)
      {
         prev=arg;
      }
       public DLNode getNext()
      {
         return next;
      }
       public DLNode getPrev()
      {
         return prev;
      }
       public Object getValue()
      {
         return value;
      }
   }
