import java.util.Scanner;

public class PrintQueueHelper {
    public static void main(String[] args) {
        PrintQueue pq = new PrintQueue();
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.print("\nAdd, Print, Delete, eXit: ");
            String resp = kb.nextLine();
            if (resp.equals("A")) {
                pq.add();
            } else if (resp.equals("P")) {
                pq.print();
            } else if (resp.equals("D")) {
                pq.delete();
            } else if (resp.equals("X")) {
                break;
            }
        }
    }
}
