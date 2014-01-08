import java.io.*;
import java.util.*;

public class Speedtest {
    public static void main(String[] args)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        LinkedList<Integer> ll = new LinkedList<Integer>();
        makeValues(al, ll);
        System.out.println("get each in ArrayList = " + timeGetEach(al));
        System.out.println("get each in LinkedList = " + timeGetEach(ll));
        System.out.println("\nadd at 0 in ArrayList = " + timeAddFirst(al));
        System.out.println("add at 0 in LinkedList = " + timeAddFirst(ll));
        System.out.println("\nadd at list.size() in ArrayList = "+timeAddLast(al));
        System.out.println("add at list.size() in LinkedList = "+timeAddLast(ll));
        System.out.println("addLast in LinkedList = " + timeAddLastLL(ll));
    }
    public static void makeValues(ArrayList<Integer> a, LinkedList<Integer> l) {
        for (int i = 0; i < 10000; i++) {
            a.add(i);
            l.add(i);
        }
    }
    public static long timeGetEach(ArrayList<Integer> a) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            a.get(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public static long timeGetEach(LinkedList<Integer> l) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            l.get(i);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public static long timeAddFirst(ArrayList<Integer> a) {
        long startTime = System.nanoTime();
        a.add(0,0);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public static long timeAddFirst(LinkedList<Integer> l) {
        long startTime = System.nanoTime();
        l.add(0,0);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public static long timeAddLast(ArrayList<Integer> a) {
        long startTime = System.nanoTime();
        a.add(a.size(),0);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public static long timeAddLast(LinkedList<Integer> l) {
        long startTime = System.nanoTime();
        l.add(l.size(),0);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public static long timeAddLastLL(LinkedList<Integer> l) {
        long startTime = System.nanoTime();
        l.addLast(0);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
