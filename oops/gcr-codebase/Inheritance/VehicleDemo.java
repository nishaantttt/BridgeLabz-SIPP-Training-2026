interface Refuelable {

    void refuel();
}

class Vehicle {

    protected String model;
    protected int maxSpeed;

    Vehicle(String model, int maxSpeed) {

        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void displayVehicle() {

        System.out.println(
                "Model: " + model);

        System.out.println(
                "Max Speed: " + maxSpeed);
    }
}

class ElectricVehicle extends Vehicle {

    ElectricVehicle(String model,
                    int maxSpeed) {

        super(model, maxSpeed);
    }

    void charge() {

        System.out.println(
                model + " is charging");
    }
}

class PetrolVehicle extends Vehicle
        implements Refuelable {

    PetrolVehicle(String model,
                  int maxSpeed) {

        super(model, maxSpeed);
    }

    @Override
    public void refuel() {

        System.out.println(
                model + " is refueling");
    }
}

public class VehicleDemo {

    public static void main(String[] args) {

        ElectricVehicle ev =
                new ElectricVehicle(
                        "Tesla Model 3",
                        250);

        PetrolVehicle pv =
                new PetrolVehicle(
                        "Honda City",
                        180);

        ev.displayVehicle();
        ev.charge();

        System.out.println();

        pv.displayVehicle();
        pv.refuel();
    }
}