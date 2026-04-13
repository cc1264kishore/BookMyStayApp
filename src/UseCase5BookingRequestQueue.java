import java.util.LinkedList;
import java.util.Queue;

// Reservation class
class Reservation {
    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public void display() {
        System.out.println("Guest: " + guestName + ", Room: " + roomType);
    }
}

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("BOOK MY STAY APP");
        System.out.println("Version : 5.0");
        System.out.println("=================================");

        // Create queue
        Queue<Reservation> bookingQueue = new LinkedList<>();

        // Add booking requests (FIFO)
        bookingQueue.add(new Reservation("Kishore", "Single Room"));
        bookingQueue.add(new Reservation("Rahul", "Double Room"));
        bookingQueue.add(new Reservation("Anu", "Suite Room"));

        System.out.println("\nBooking Requests in Queue:");

        // Display queue (without removing)
        for (Reservation r : bookingQueue) {
            r.display();
        }

        System.out.println("\nNext Request to Process (FIFO):");
        bookingQueue.peek().display(); // first request
    }
}