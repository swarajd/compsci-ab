public class LList {
   private ListNode front;
   private ListNode rear;
     
   public LList() {
             
   }
   public ListNode getFront() {
      return front;
   }
   public ListNode getRear() {
      return rear;
   }
   public void printWhile() {
      ListNode temp = front;
      while (!(temp == null)) {
         System.out.println(temp.getValue());
         temp = temp.getNext();
      }
   }
   public void printFor() {
      for (ListNode temp = front; !(temp == null); temp = temp.getNext()) {
         System.out.println(temp.getValue());
      }
   }
   public void addFirst(Object obj) {
      if (front == null) {
         front = new ListNode(obj, rear);
      } 
      else {
         ListNode newfirst = new ListNode(obj, front);
			ListNode temp = front;
         front = newfirst;
			if (rear == null) {
				rear = temp;
			}
      }
   }
   public void addLast(Object obj) {
      if (rear == null) {
         rear = new ListNode(obj, null);
      } 
      else {
         ListNode newlast = new ListNode(obj, null);
			ListNode temp = rear;
         rear.setNext(newlast);
         rear = newlast;
			if (front == null) {
				front = temp;
			}
      }
   }
}
