import java.util.Stack;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

/*
 * regexes I'll use
 * "\\( |\\) |\\d+\\.?\\d* |[+-/%^!*]"
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class Infix {
    public static final String operators = "+-*/%^!";
    public static String convert(String str) {
        if (!ParenMatch.check(str)) {
            System.out.println("bad string");
            return str;
        }
        Stack stack = new Stack();
        String postfix = "";
        String addInLater = "(?:[\\( ])";
        
        //regex
        String pattern = "(\\()|(\\))|(-?\\d+\\.?\\d*)|([+-/%^!*])";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        ArrayList<String> parts = new ArrayList();
        
        while (m.find()) {
            parts.add(m.group());
        }
        
        for(String s: parts) {
            System.out.println("part: " + s);
        }
        
        for(String s: parts) {
            if (isNum(s)) {
                postfix += " " + s + " ";
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.empty() && !stack.peek().equals("(")) {
                    postfix += (" " + stack.pop() + " ");
                }
                stack.pop();
            } else if (isOperator(s)) {
                if (stack.empty()) {
                    stack.push(s);
                } else {
                    while (!stack.empty() && !stack.peek().equals('(') && isLower(s,stack.peek().toString())) {
                        postfix += ( " " + stack.pop() + " ");
                    }
                    stack.push(s);
                }
            }
        }
        
        while (!stack.empty()) {
            postfix += (" " + stack.pop() + " ");
        }
        return postfix;
    }
    public static boolean isNum(String sn) {
        Pattern r = Pattern.compile("-?\\d+\\.?\\d*");
        Matcher m = r.matcher(sn);
        return m.matches();
    }
    public static boolean isLower(String c1, String c2) {
        if (c1.equals("*") || c1.equals("/") || c1.equals("%")) {
            if (c2.equals("^")) {
                return true;
            }
            return false;
        }
        if (c1.equals("+") || c1.equals("-")) {
            if (c2.equals("*") || c2.equals("/") || c2.equals("^") || c2.equals("%")) {
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
        String test1 = "(3*(-4+5)-2)/5";
        String test2 = "-4 * 5 - 2";
        String lolnope = "-4 + 5 - -1 ^ 2";
        System.out.println(convert(lolnope));
    }
}
