import java.util.*;

// Reservation class
class ReservationUC8 {
    String guestName;
    String roomType;

    public ReservationUC8(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

// Booking History class
class BookingHistory {

    private List<ReservationUC8> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // Add booking
    public void addReservation(ReservationUC8 r) {
        history.add(r);
    }

    // Display all bookings
    public void displayHistory() {
        System.out.println("\n===== BOOKING HISTORY =====");

        for (ReservationUC8 r : history) {
            System.out.println("Guest: " + r.guestName +
                    ", Room: " + r.roomType);
        }
    }

    // Report
    public void generateReport() {
        System.out.println("\n===== REPORT =====");
        System.out.println("Total Bookings: " + history.size());
    }
}

public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("BOOK MY STAY APP");
        System.out.println("Version : 8.0");
        System.out.println("=================================");

        BookingHistory bh = new BookingHistory();

        // Add confirmed bookings
        bh.addReservation(new ReservationUC8("Kishore", "Single Room"));
        bh.addReservation(new ReservationUC8("Rahul", "Double Room"));
        bh.addReservation(new ReservationUC8("Anu", "Suite Room"));

        // Display history
        bh.displayHistory();

        // Generate report
        bh.generateReport();
    }
}