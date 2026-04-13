import java.util.*;

// Service class
class Service {
    String name;
    int cost;

    public Service(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("BOOK MY STAY APP");
        System.out.println("Version : 7.0");
        System.out.println("=================================");

        // Map: ReservationID -> List of Services
        HashMap<String, List<Service>> serviceMap = new HashMap<>();

        String reservationId = "RES101";

        // Create services
        List<Service> services = new ArrayList<>();
        services.add(new Service("Breakfast", 200));
        services.add(new Service("WiFi", 100));
        services.add(new Service("Airport Pickup", 500));

        // Store mapping
        serviceMap.put(reservationId, services);

        System.out.println("\nServices for Reservation: " + reservationId);

        int totalCost = 0;

        for (Service s : serviceMap.get(reservationId)) {
            System.out.println(s.name + " - ₹" + s.cost);
            totalCost += s.cost;
        }

        System.out.println("\nTotal Add-On Cost: ₹" + totalCost);
    }
}