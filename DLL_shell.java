// name:    date:
    public class DLL_shell
   {
       public static void main(String args[])
      {
         DLL list = new DLL();
         System.out.println(list);
         list.addFirst("cookie");
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
          if (obj == null) {
              return true;
          }
          if (size == 0 || head.getValue() == null) {
              head = new DLNode(obj, null, null);
              head.setPrev(head);
              head.setNext(head);
          } else if (head.getNext().equals(head)) {
              DLNode insertNode = new DLNode(obj, head, head);
              head.setNext(insertNode);
              head.setPrev(insertNode);
          } else {
              DLNode iter = head;
              DLNode init = head;
              while (!(iter.getNext().equals(init))) {
                  iter = iter.getNext();
              }
              DLNode insertNode = new DLNode(obj, iter, init);
              iter.setNext(insertNode);
              init.setPrev(insertNode);
          }
          size++;
          return true;
      }
      /* inserts obj at position index.  increments size. 
   		*/
       public void add(int index, Object obj)
      {
          if (obj == null) {
              return;
          }
          if (size == 0) {
              head = new DLNode(obj, null, null);
              head.setNext(head);
              head.setPrev(head);
          } else {
              DLNode iter = head;
              for (int i = 0; i < index; i++) {
                  iter = iter.getNext();
              }
              DLNode insertNode = new DLNode(obj, iter.getPrev(), iter);              
              iter.getPrev().setNext(insertNode);
              iter.setPrev(insertNode);
              if (index == 0) {
                  head = insertNode;
              }
              size++;
          }
      }
      /* return obj at position index.  
   		*/
       public Object get(int index)
      {
          if (size != 0) {
              DLNode iter = head;
              for (int i = 0; i < index; i++) {
                  iter = iter.getNext();
              }
              return iter.getValue();
          } else {
              return null;
          }
      }
    /* replaces obj at position index.  
   		*/
       public void set(int index, Object obj)
      {
          if (size != 0 && size > index) {
              DLNode iter = head;
              for (int i = 0; i < index; i++) {
                  iter = iter.getNext();
              }
              iter.setValue(obj);
          }
      }
    /*  removes the node from position index.  decrements size.
   	  @return the object at position index.
   	 */
       public Object remove(int index)
      {
          if (size != 0 && size > index) {
              DLNode iter = head.getPrev();
              for (int i = 0; i < index; i++) {
                  iter = iter.getNext();
              }
              Object val = iter.getNext().getValue();
              iter.getNext().getNext().setPrev(iter);
              iter.setNext(iter.getNext().getNext());
              if (index == 0) {
                  head = iter.getNext();
              }
              size--;
              return val;
          } else {
              return null;
          }
      }
    /* inserts obj at front of list; increases size;
   	  */
       public void addFirst(Object obj)
      {
          if (obj == null) {
              return;
          }
          if (size == 0) {
              head = new DLNode(obj, null, null);
              head.setNext(head);
              head.setPrev(head);
              size++;
          } else {
              DLNode iter = head;
              DLNode insertNode = new DLNode(obj, iter.getPrev(), iter);              
              iter.getPrev().setNext(insertNode);
              iter.setPrev(insertNode);
              head = insertNode;
              size++;
          }
      }
   	/* appends obj to end of list; increases size;
   	    */
       public void addLast(Object obj)
      {
          if (obj == null) {
              return;
          }
          if (size == 0 || head.getValue() == null) {
              head = new DLNode(obj, null, null);
              head.setPrev(head);
              head.setNext(head);
          } else if (head.getNext().equals(head)) {
              DLNode insertNode = new DLNode(obj, head, head);
              head.setNext(insertNode);
              head.setPrev(insertNode);
          } else {
              DLNode iter = head;
              DLNode init = head;
              while (!(iter.getNext().equals(init))) {
                  iter = iter.getNext();
              }
              DLNode insertNode = new DLNode(obj, iter, init);
              iter.setNext(insertNode);
              init.setPrev(insertNode);
          }
          size++;
      }
       public Object getFirst()
      {
          return head.getValue();
      }
       public Object getLast()
      {
          DLNode temp = head.getNext();
          while (!(temp.getNext().equals(head))) {
              temp = temp.getNext();
          }
          return temp.getValue();
      }
       public Object removeFirst()
      {
          if (size == 0) {
              return null;
          }
          if (size == 1) {
              head = null;
              return null;
          }
          return this.remove(0);
      }
       public Object removeLast()
      {
          if (size == 0) {
              return null;
          }
          if (size == 1) {
              head = null;
              size--;
              return null;
          }
          return this.remove(this.size()-1);
      }
       public String toString()
      {
          if (size == 0) {
              return "[]";
          } else if (head.getNext().equals(head)) {
              return "[" + head.getValue() + "]";
          } else {
              String ret = "[" + (String)head.getValue() + ", ";
              for (DLNode temp = head.getNext(); (!(temp.equals(head))); temp = temp.getNext()) {
                  ret = ret + (String)temp.getValue() + ", ";
              }
              ret = ret + "]";
              return ret;
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
