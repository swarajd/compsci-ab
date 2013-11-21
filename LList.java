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
		if (front == null && rear == null) {
			System.out.println("[]");
			return;
		}
		System.out.print("[");
      ListNode temp = front;
      while (!(temp == null)) {
         System.out.print(temp.getValue() + ", ");
         temp = temp.getNext();
      }
		System.out.println("]");
   }
   public void printFor() {
		System.out.print("[");
      for (ListNode temp = front; !(temp == null); temp = temp.getNext()) {
         System.out.print(temp.getValue() + ", ");
      }
		System.out.println("]");
   }
   public void addFirst(Object obj) {
		if (front == null) {
			ListNode temp = new ListNode(obj, null);
			front = temp;
			if (rear == null) {
				rear = temp;
			}
		} else {
			ListNode temp = new ListNode(obj, front);
			front = temp;
			if (rear == null) {
				rear = temp;
			}
		}
   }
   public void addLast(Object obj) {
		if (rear == null) {
			ListNode temp = new ListNode(obj, null);
			rear = temp;
			if (front == null) {
				front = temp;
			}
		} else {
			ListNode rear_ = new ListNode(obj, null);
			ListNode temp = rear;
			rear.setNext(rear_);
			rear = rear.getNext();
			if (front == null) {
				front = temp;
			}
		}
   }
}
