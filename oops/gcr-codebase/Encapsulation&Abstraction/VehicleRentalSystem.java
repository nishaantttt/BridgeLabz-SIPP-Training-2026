abstract class Vehicle {

    private String vehicleNumber;
    private String vehicleType;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public abstract double calculateRentalCost(int days);

    public void displayVehicleInfo() {
        System.out.println("Vehicle No: " + vehicleNumber);
        System.out.println("Type: " + vehicleType);
    }
}

class Car extends Vehicle {

    private double dailyRate;

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Bike extends Vehicle {

    private double dailyRate;

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Truck extends Vehicle {

    private double dailyRate;
    private double loadingCharge;

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public void setLoadingCharge(double loadingCharge) {
        this.loadingCharge = loadingCharge;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (days * dailyRate) + loadingCharge;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {

        Car car = new Car();
        car.setVehicleNumber("UP85C101");
        car.setVehicleType("Car");
        car.setDailyRate(1500);

        Bike bike = new Bike();
        bike.setVehicleNumber("UP85B101");
        bike.setVehicleType("Bike");
        bike.setDailyRate(500);

        Truck truck = new Truck();
        truck.setVehicleNumber("UP85T101");
        truck.setVehicleType("Truck");
        truck.setDailyRate(3000);
        truck.setLoadingCharge(2000);

        car.displayVehicleInfo();
        System.out.println("Rental Cost = ₹" + car.calculateRentalCost(3));

        System.out.println();

        bike.displayVehicleInfo();
        System.out.println("Rental Cost = ₹" + bike.calculateRentalCost(3));

        System.out.println();

        truck.displayVehicleInfo();
        System.out.println("Rental Cost = ₹" + truck.calculateRentalCost(3));
    }
}