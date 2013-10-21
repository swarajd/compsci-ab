//your name and date
import java.util.Scanner;

class ListNode
{
  private Object value;
  private ListNode next;
   public ListNode(Object v, ListNode n)
  {
	 value=v;
	 next=n;
  }
   public Object getValue()
  {
	 return value;
  }
   public ListNode getNext()
  {
	 return next;
  }
   public void setValue(Object newv)
  {
	 value=newv;
  }
   public void setNext(ListNode newn)
  {
	 next=newn;
  }

}

class ListLab1_shell
{
	private static ListNode copyNode(ListNode arg)
	{
		ListNode n = arg;
		return n;
	}
	private static ListNode copyList(ListNode arg)
	{
		ListNode n;
		if (arg.getNext() != null)
		{
			n = new ListNode(arg.getValue(), copyList(arg.getNext()));
		}
		else
		{
			n = new ListNode(arg.getValue(), null);
		}
		return n;
	}
	private static ListNode rest(ListNode arg)
	{
		ListNode cpy = copyList(arg);
		return cpy.getNext();
	}
	public static Object first(ListNode head)
	{
		if (head != null)
		{
			return head.getValue();
		}
		else
		{
			return null;
		}
	}
	public static Object second(ListNode head)
	{
		if (head != null)
		{
			return rest(head).getValue();
		}
		else
		{
			return null;
		}
	}
	public static ListNode pointerToLast(ListNode head)
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
	public static ListNode copyOfLast(ListNode head)
	{
			ListNode cpy = new ListNode(pointerToLast(head).getValue(),pointerToLast(head).getNext());
			return cpy;
	}
	public static ListNode insertFirst(ListNode head, Object arg)
	{
		ListNode head_ = new ListNode(arg, head);
		return head_;
	}
	public static ListNode insertLast(ListNode head, Object arg)
	{
		ListNode head_ = head;
		ListNode temp = head_;
		while (temp.getNext() != null)
		{
			temp = temp.getNext();
		}
		temp.setNext(new ListNode(arg, null));
		return  head;
	}
	public static void main(String[] args)
	{
		ListNode head = new ListNode("hello", null);
		head = new ListNode("foo", head);
		head = new ListNode("boo", head);
		head = new ListNode("nonsense", head);
		head = new ListNode("computer",
		new ListNode("science",
			new ListNode("java",
					new ListNode("coffee", head)
				)
			)
		);
		System.out.println(first(head));
		System.out.println(second(head));
		ListNode ptl = pointerToLast(head);
		System.out.println(ptl);
		ListNode cpy = copyOfLast(head);
		System.out.println(cpy);
		head = insertFirst(head,"what");
		head = insertLast(head,"what");
		print(head);

		/**** uncomment the code below for ListLab1 Extension  ****/

		// System.out.println("First = " + first(head));
		// System.out.println("Second = " + second(head));
		// ListNode p = pointerToLast(head);
		// System.out.println("Pointer to Last = " + p.getValue()+ " at " + p);
		// ListNode c = copyOfLast(head);
		// System.out.println("Copy of Last =    " + c.getValue()+ " at " + c);
		// 	
		// Scanner in = new Scanner(System.in);
		// System.out.print("Insert what? ");
		// String x = in.next();
		// head = insertFirst(head, x);
		// head = insertLast(head, x)
		// print(head);
	}
	public static void print(ListNode head)
	{
		System.out.print("[");
		while(head != null)
		{
			System.out.print(head.getValue());
			head = head.getNext();
			if(head != null)
				System.out.print(", ");
		}
		System.out.println("]");
	}
}
