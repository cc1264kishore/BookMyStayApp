class RoomUC3 {
    String type;
    int beds;
    double price;

    public RoomUC3(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    public void displayRoomDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Beds: " + beds);
        System.out.println("Price: " + price);
    }
}

public class UseCase3RoomInventory {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("BOOK MY STAY APP");
        System.out.println("Version : 3.0");
        System.out.println("=================================");

        RoomUC3[] rooms = new RoomUC3[3];

        rooms[0] = new RoomUC3("Single Room", 1, 1000);
        rooms[1] = new RoomUC3("Double Room", 2, 2000);
        rooms[2] = new RoomUC3("Suite Room", 3, 5000);

        int[] availability = {5, 3, 2};

        for (int i = 0; i < rooms.length; i++) {
            rooms[i].displayRoomDetails();
            System.out.println("Available Rooms: " + availability[i]);
            System.out.println("---------------------------");
        }
    }
}