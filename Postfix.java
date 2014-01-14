import java.util.Stack;
import java.util.Scanner;
import java.lang.Math;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 * regexes I'll use
 * "\d+\.?\d*" for numbers
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class Postfix {
    public static final String operators = "+-*/%^!";
    public static final String validChars = operators + "0123456789"; // no spaces atm
    public static int eval(String st) {
        Stack stack = new Stack();
        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);
            if (!isOperator(c)) {
                stack.push(c);
            } else {
                int a;
                int b;
                try {
                    a = Integer.valueOf(stack.pop().toString());
                    b = Integer.valueOf(stack.pop().toString());
                } catch (java.util.EmptyStackException e) {
                    System.out.println("bad string");
                    return 0;
                }
                stack.push(eval(a,b,c));
            }
        }
        return (Integer)stack.pop();
    }
    private static int eval(int a, int b, char ch) {
        String op = "" + ch;
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return b - a;
        } else if (op.equals("*")) {
            return a * b;
        } else if (op.equals("/")) {
            if (a == 0) {
                throw new java.lang.ArithmeticException();
            }
            return b / a;
        } else if (op.equals("^")) {
            return (int)Math.pow(a,b);
        } else if (op.equals("%")) {
            return a % b;
        } else if (op.equals("!")) {
            int res = 1;
            for (int i = 1; i <= a; i++) {
                res *= i;
            }
            return res;
        } else {
            return 0;
        }
    }
    public static boolean isOperator(char ch) {
        return (operators.contains("" + ch));
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("enter a postfix string: ");
        String st = kb.nextLine();
        System.out.println(eval(st));
    }
}
