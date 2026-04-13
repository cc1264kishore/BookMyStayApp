import java.util.*;

// Custom Exception
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Inventory Class
class InventoryUC9 {

    private HashMap<String, Integer> rooms;

    public InventoryUC9() {
        rooms = new HashMap<>();
        rooms.put("Single", 2);
        rooms.put("Double", 1);
        rooms.put("Suite", 0);
    }

    public void bookRoom(String type) throws InvalidBookingException {

        // Validate room type
        if (!rooms.containsKey(type)) {
            throw new InvalidBookingException("Invalid Room Type: " + type);
        }

        // Check availability
        int available = rooms.get(type);

        if (available <= 0) {
            throw new InvalidBookingException("No rooms available for: " + type);
        }

        // Update inventory
        rooms.put(type, available - 1);

        System.out.println("Booking confirmed for " + type + " room");
    }

    public void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        for (String key : rooms.keySet()) {
            System.out.println(key + " Rooms Available: " + rooms.get(key));
        }
    }
}

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("BOOK MY STAY APP");
        System.out.println("Version : 9.0");
        System.out.println("=================================");

        InventoryUC9 inventory = new InventoryUC9();

        try {
            inventory.bookRoom("Single");   // valid
            inventory.bookRoom("Suite");    // no availability
            inventory.bookRoom("Luxury");   // invalid type
        } catch (InvalidBookingException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        inventory.displayInventory();
    }
}