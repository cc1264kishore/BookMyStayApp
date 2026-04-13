abstract class Room {

    String type;
    int beds;
    double price;

    public Room(String type, int beds, double price) {
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

class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 1000);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 2000);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 5000);
    }
}

public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("BOOK MY STAY APP");
        System.out.println("Version : 2.0");
        System.out.println("=================================");

        // Create objects (Polymorphism)
        Room single = new SingleRoom();
        Room doub = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display details
        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailable);
        System.out.println();

        doub.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable);
        System.out.println();

        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}