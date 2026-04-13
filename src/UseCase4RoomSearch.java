import java.util.HashMap;

class RoomInventoryUC4 {

    private HashMap<String, Integer> inventory;

    // Constructor
    public RoomInventoryUC4() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Check availability
    public boolean isAvailable(String roomType) {
        return inventory.containsKey(roomType) && inventory.get(roomType) > 0;
    }

    // Get availability count
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("BOOK MY STAY APP");
        System.out.println("Version : 4.0");
        System.out.println("=================================");

        RoomInventoryUC4 inventory = new RoomInventoryUC4();

        // Search room
        String searchRoom = "Single Room";   // you can change this

        System.out.println("Searching for: " + searchRoom);

        if (inventory.isAvailable(searchRoom)) {
            System.out.println("Room Available!");
            System.out.println("Available Count: " +
                    inventory.getAvailability(searchRoom));
        } else {
            System.out.println("Room Not Available!");
        }
    }
}