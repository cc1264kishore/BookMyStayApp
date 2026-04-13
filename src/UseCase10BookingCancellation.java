import java.util.*;

// Reservation class
class ReservationUC10 {
    String reservationId;
    String roomType;

    public ReservationUC10(String id, String type) {
        this.reservationId = id;
        this.roomType = type;
    }
}

// Inventory class
class InventoryUC10 {

    HashMap<String, Integer> rooms = new HashMap<>();

    public InventoryUC10() {
        rooms.put("Single", 2);
        rooms.put("Double", 1);
        rooms.put("Suite", 1);
    }

    public boolean allocateRoom(String type) {
        if (rooms.containsKey(type) && rooms.get(type) > 0) {
            rooms.put(type, rooms.get(type) - 1);
            return true;
        }
        return false;
    }

    public void rollbackRoom(String type) {
        rooms.put(type, rooms.get(type) + 1);
    }

    public void display() {
        System.out.println("\nInventory:");
        for (String key : rooms.keySet()) {
            System.out.println(key + " -> " + rooms.get(key));
        }
    }
}

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("BOOK MY STAY APP");
        System.out.println("Version : 10.0");
        System.out.println("=================================");

        InventoryUC10 inventory = new InventoryUC10();

        // Store active bookings
        HashMap<String, ReservationUC10> bookings = new HashMap<>();

        // Stack for rollback (LIFO)
        Stack<String> rollbackStack = new Stack<>();

        // ---- BOOKING ----
        String resId = "RES101";
        String roomType = "Single";

        if (inventory.allocateRoom(roomType)) {
            bookings.put(resId, new ReservationUC10(resId, roomType));
            rollbackStack.push(resId);
            System.out.println("Booking confirmed: " + resId);
        } else {
            System.out.println("Booking failed");
        }

        inventory.display();

        // ---- CANCELLATION ----
        System.out.println("\nCancelling booking...");

        if (bookings.containsKey(resId)) {

            ReservationUC10 r = bookings.get(resId);

            // rollback using stack
            if (!rollbackStack.isEmpty() && rollbackStack.peek().equals(resId)) {
                rollbackStack.pop();
            }

            inventory.rollbackRoom(r.roomType);
            bookings.remove(resId);

            System.out.println("Cancellation successful: " + resId);

        } else {
            System.out.println("Invalid reservation ID");
        }

        inventory.display();
    }
}