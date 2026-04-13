import java.util.*;

// Reservation class
class ReservationUC6 {
    String guestName;
    String roomType;

    public ReservationUC6(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("BOOK MY STAY APP");
        System.out.println("Version : 6.0");
        System.out.println("=================================");

        // Queue (FIFO)
        Queue<ReservationUC6> queue = new LinkedList<>();

        queue.add(new ReservationUC6("Kishore", "Single Room"));
        queue.add(new ReservationUC6("Rahul", "Double Room"));
        queue.add(new ReservationUC6("Anu", "Single Room"));

        // Inventory (HashMap)
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);

        // Allocated room IDs (Set → no duplicates)
        HashMap<String, Set<String>> allocatedRooms = new HashMap<>();

        System.out.println("\nProcessing Booking Requests...\n");

        while (!queue.isEmpty()) {

            ReservationUC6 req = queue.poll();

            String roomType = req.roomType;

            // Check availability
            if (inventory.getOrDefault(roomType, 0) > 0) {

                // Generate unique room ID
                String roomId = roomType.substring(0, 2).toUpperCase() +
                        (int)(Math.random() * 1000);

                // Initialize set if not exists
                allocatedRooms.putIfAbsent(roomType, new HashSet<>());

                // Ensure uniqueness
                while (allocatedRooms.get(roomType).contains(roomId)) {
                    roomId = roomType.substring(0, 2).toUpperCase() +
                            (int)(Math.random() * 1000);
                }

                // Store allocated ID
                allocatedRooms.get(roomType).add(roomId);

                // Update inventory
                inventory.put(roomType, inventory.get(roomType) - 1);

                // Confirm booking
                System.out.println("Booking Confirmed!");
                System.out.println("Guest: " + req.guestName);
                System.out.println("Room Type: " + roomType);
                System.out.println("Room ID: " + roomId);
                System.out.println("-------------------------");

            } else {
                System.out.println("Booking Failed (No Availability)");
                System.out.println("Guest: " + req.guestName);
                System.out.println("Room Type: " + roomType);
                System.out.println("-------------------------");
            }
        }
    }
}