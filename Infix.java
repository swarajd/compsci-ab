import java.util.Stack;
import java.util.Scanner;

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

public class Infix {
    public static final String operators = "+-*/";
    public static String convert(String str) {
        if (!ParenMatch.check(str)) {
            System.out.println("bad string");
            return str;
        }
        Stack stack = new Stack();
        String postfix = "";
        for (int i = 0; i < str.length(); i++) {
            String s = "" + str.charAt(i);
            if (Character.isDigit(s.charAt(0))) {
                postfix += s;
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.empty() && !stack.peek().equals("(")) {
                    postfix += stack.pop();
                }
                stack.pop();
            } else if (isOperator(s)) {
                if (stack.empty()) {
                    stack.push(s);
                } else {
                    while (!stack.empty() && !stack.peek().equals('(') && isLower(s,stack.peek().toString())) {
                        postfix += stack.pop();
                    }
                    stack.push(s);
                }
            } 
        }
        while (!stack.empty()) {
            postfix += stack.pop();
        }
        return postfix;
    }
    public static boolean isLower(String c1, String c2) {
        if (c1.equals("+") || c1.equals("-")) {
            if (c2.equals("*") || c2.equals("/")) {
                return true;
            }
            return false;
        }
        return false;
    }
    public static boolean isOperator(String str) {
        return (operators.contains(str));
    }
    public static void main(String[] args) {
        System.out.println(convert("((3+4) + 5)"));
    }
}
