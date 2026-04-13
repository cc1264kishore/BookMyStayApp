import java.io.*;
import java.util.*;

// Serializable Inventory Class
class InventoryUC12 implements Serializable {

    HashMap<String, Integer> rooms;

    public InventoryUC12() {
        rooms = new HashMap<>();
        rooms.put("Single", 2);
        rooms.put("Double", 1);
    }

    public void display() {
        System.out.println("Inventory:");
        for (String key : rooms.keySet()) {
            System.out.println(key + " -> " + rooms.get(key));
        }
    }
}

public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("BOOK MY STAY APP");
        System.out.println("Version : 12.0");
        System.out.println("=================================");

        String fileName = "inventory.dat";

        // -------- SAVE DATA --------
        InventoryUC12 inventory = new InventoryUC12();

        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream(fileName));

            out.writeObject(inventory);
            out.close();

            System.out.println("\nData saved successfully ✅");

        } catch (Exception e) {
            System.out.println("Error saving data");
        }

        // -------- LOAD DATA --------
        try {
            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream(fileName));

            InventoryUC12 loaded =
                    (InventoryUC12) in.readObject();

            in.close();

            System.out.println("\nData loaded successfully ✅");
            loaded.display();

        } catch (Exception e) {
            System.out.println("Error loading data");
        }
    }
}