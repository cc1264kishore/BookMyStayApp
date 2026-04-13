import java.util.*;

// Shared Inventory (Thread Safe)
class InventoryUC11 {

    private HashMap<String, Integer> rooms = new HashMap<>();

    public InventoryUC11() {
        rooms.put("Single", 2);
    }

    // synchronized method (critical section)
    public synchronized void bookRoom(String user) {

        int available = rooms.get("Single");

        if (available > 0) {
            System.out.println(user + " is booking...");

            // simulate delay
            try { Thread.sleep(100); } catch (Exception e) {}

            rooms.put("Single", available - 1);

            System.out.println(user + " SUCCESS ✅");
        } else {
            System.out.println(user + " FAILED ❌ (No rooms)");
        }
    }

    public void display() {
        System.out.println("Remaining Rooms: " + rooms.get("Single"));
    }
}

// Thread class
class BookingThread extends Thread {

    private InventoryUC11 inventory;
    private String user;

    public BookingThread(InventoryUC11 inventory, String user) {
        this.inventory = inventory;
        this.user = user;
    }

    public void run() {
        inventory.bookRoom(user);
    }
}

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("BOOK MY STAY APP");
        System.out.println("Version : 11.0");
        System.out.println("=================================");

        InventoryUC11 inventory = new InventoryUC11();

        // Multiple users (threads)
        BookingThread t1 = new BookingThread(inventory, "User1");
        BookingThread t2 = new BookingThread(inventory, "User2");
        BookingThread t3 = new BookingThread(inventory, "User3");

        // start threads
        t1.start();
        t2.start();
        t3.start();

        // wait for threads
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {}

        inventory.display();
    }
}