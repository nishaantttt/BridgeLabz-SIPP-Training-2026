import java.util.ArrayList;

public class SmartParkingSlotManager {

    static ArrayList<String> vehicles = new ArrayList<>();

    static void vehicleEntry(String regNo) {
        vehicles.add(regNo);
        System.out.println(regNo + " entered parking.");
    }

    static void vehicleExit(String regNo) {
        if (vehicles.remove(regNo))
            System.out.println(regNo + " exited parking.");
        else
            System.out.println("Vehicle not found.");
    }

    static void searchVehicle(String regNo) {
        if (vehicles.contains(regNo))
            System.out.println(regNo + " is parked.");
        else
            System.out.println(regNo + " is not parked.");
    }

    static void displayVehicles() {
        System.out.println("\nParked Vehicles:");
        for (String v : vehicles)
            System.out.println(v);

        System.out.println("Occupied Slots: " + vehicles.size());
    }

    public static void main(String[] args) {

        vehicleEntry("UP32AB1234");
        vehicleEntry("DL01XY5678");
        vehicleEntry("HR26AA1111");

        searchVehicle("DL01XY5678");

        vehicleExit("HR26AA1111");

        displayVehicles();
    }
}