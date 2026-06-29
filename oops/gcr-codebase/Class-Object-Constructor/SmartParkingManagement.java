class Vehicle {

    private String vehicleNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String vehicleNumber,
                   String ownerName,
                   String vehicleType) {

        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void display() {
        System.out.println(vehicleNumber +
                " | " +
                ownerName +
                " | " +
                vehicleType);
    }
}

public class SmartParkingManagement {

    public static void displayCars(Vehicle[] vehicles) {
        System.out.println("\nCars:");
        for (Vehicle v : vehicles) {
            if (v.getVehicleType().equalsIgnoreCase("Car")) {
                v.display();
            }
        }
    }

    public static void displayBikes(Vehicle[] vehicles) {
        System.out.println("\nBikes:");
        for (Vehicle v : vehicles) {
            if (v.getVehicleType().equalsIgnoreCase("Bike")) {
                v.display();
            }
        }
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Vehicle("UP85A101", "Mayank", "Car"),
                new Vehicle("UP85A102", "Ravi", "Bike"),
                new Vehicle("UP85A103", "Aman", "Car"),
                new Vehicle("UP85A104", "Rohit", "Bike"),
                new Vehicle("UP85A105", "Neha", "Car"),
                new Vehicle("UP85A106", "Priya", "Bike"),
                new Vehicle("UP85A107", "Karan", "Car"),
                new Vehicle("UP85A108", "Ankit", "Bike"),
                new Vehicle("UP85A109", "Rahul", "Car"),
                new Vehicle("UP85A110", "Pooja", "Bike")
        };

        displayCars(vehicles);
        displayBikes(vehicles);
    }
}