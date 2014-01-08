import java.util.Stack;
import java.util.Scanner;

public class ParenMatch {
    public static final String LEFT = "([{<";
    public static final String RIGHT = ")]}>";
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("enter a string: ");
        String st = kb.nextLine();
        
        if (check(st)) {
            System.out.println(st + " is good");
        } else {
            System.out.println(st + " is bad");
        }
    }
    public static boolean check(String s) {
        Stack st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            String c = "" + s.charAt(i);
            if (LEFT.contains(c)) {
                st.push(c);
            } else if (RIGHT.contains(c)) {
                try {
                    
                    String popped = (String)st.pop();
                    if (!checkReverseChar(popped,c)) {
                        return false;
                    }
                } catch (java.util.EmptyStackException err) {
                    return false;
                }
            }
        }
        return (st.size() == 0);
    }
    public static boolean checkReverseChar(String s1, String s2) {
        if (s1.equals("(")) {
            return s2.equals(")");
        } else if (s1.equals("<")) {
            return s2.equals(">");
        } else if (s1.equals("[")) {
            return s2.equals("]");
        } else if (s1.equals("{")) {
            return s2.equals("}");
        } else {
            return false;
        }
    }
}
