import java.util.Stack;
import java.util.Scanner;
import java.lang.Math;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

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
    public static final String validChars = operators + ".0123456789 "; // no spaces atm
    public static double eval(String st) {
        Stack stack = new Stack();
        
        //check unknown symbols
        String usp = "[^+-/%^!.0123456789 *]";
        Pattern ur = Pattern.compile(usp);
        Matcher um = ur.matcher(st);
        if (um.find()) {
            System.out.println("bad string");
            return 0;
        }
        
        String pattern = "(-?\\d+\\.?\\d*)|([+-/%^!*])";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(st);
        ArrayList<String> parts = new ArrayList();
        
        while (m.find()) {
            parts.add(m.group());
        }
        
        for (String s: parts) {
            if (!isOperator(s)) {
                stack.push(s);
            } else {
                double a;
                double b;
                if (!s.equals("!")) { //factorial
                    try {
                        String stra = stack.pop().toString();
                        String strb = stack.pop().toString();
                        if (isInteger(stra)) {
                            a = Integer.parseInt(stra) * 1.0;
                        } else {
                            a = Double.parseDouble(stra);
                        }
                        if (isInteger(strb)) {
                            b = Integer.parseInt(strb);
                        } else {
                            b = Double.parseDouble(strb);
                        }
                    } catch (java.util.EmptyStackException e) {
                        System.out.println("bad string");
                        return 0;
                    }
                } else { //no factorial
                    try {
                        a = 0;
                        b = Double.parseDouble(stack.pop().toString());
                    } catch (java.util.EmptyStackException e) {
                        System.out.println("bad string");
                        return 0;
                    }
                }
                stack.push(eval(a,b,s));
            }
        }
        return (double)stack.pop();
    }
    private static double eval(double a, double b, String op) {
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
            return Math.pow(b,a);
        } else if (op.equals("%")) {
            return a % b;
        } else if (op.equals("!")) {
            int res = 1;
            for (int i = 1; i <= b; i++) {
                res *= i;
            }
            return res;
        } else {
            return 0;
        }
    }
    public static boolean isOperator(String op) {
        return (operators.contains(op));
    }
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        // only got here if we didn't return false
        return true;
    }
    public static boolean isDouble(String s) {
        try { 
            Double.parseDouble(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }
        // only got here if we didn't return false
        return true;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("enter a postfix string: ");
        String st = kb.nextLine();
        System.out.println(eval(st));
    }
}
