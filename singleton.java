import java.util.Queue;
import java.util.LinkedList;

public class PrinterSpooler {
    private static PrinterSpooler instance;
    private Queue<String> printQueue;

    private PrinterSpooler() {
        printQueue = new LinkedList<>();
    }

    public static synchronized PrinterSpooler getInstance() {
        if (instance == null) {
            instance = new PrinterSpooler();
        }
        return instance;
    }

    public synchronized void addToQueue(String document) {
        printQueue.add(document);
    }

    public synchronized String removeFromQueue() {
        return printQueue.poll();
    }

    public synchronized boolean isQueueEmpty() {
        return printQueue.isEmpty();
    }

    public static void main(String[] args) {
        PrinterSpooler spooler = PrinterSpooler.getInstance();
        spooler.addToQueue("Document from User 1");
        spooler.addToQueue("Document from User 2");
        while (!spooler.isQueueEmpty()) {
            String document = spooler.removeFromQueue();
            System.out.println("Printing: " + document);
        }
    }
}
