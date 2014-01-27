import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class PrintQueue {
    int ind;
    Queue<Integer> queue;
    Scanner kb = new Scanner(System.in);
    PrintQueue() {
        queue = new LinkedList<Integer>();
        Scanner kb = new Scanner(System.in);
        ind = 100;
    }
    void add() {
        queue.add(ind);
        ind++;
        printQueue();
    }
    void print() {
        queue.remove();
        printQueue();
    }
    void delete() {
        System.out.print("Enter job number: ");
        int jn;
        jn = kb.nextInt();
        
        if (!queue.remove(jn)) {
            System.out.println("Error--job does not exist.");
        }
        printQueue();
    }
    void printQueue() {
        for (int i: queue) {
            System.out.print(i + " ");
        }
    }
}
