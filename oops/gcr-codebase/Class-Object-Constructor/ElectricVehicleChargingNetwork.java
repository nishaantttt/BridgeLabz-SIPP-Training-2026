class ChargingStation {

    static int totalStations = 0;
    static double electricityRate = 8.5;

    private int stationId;
    private double unitsConsumed;

    public ChargingStation(int stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    public double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    public void displayStationDetails() {
        System.out.println("Station ID : " + stationId);
        System.out.println("Units      : " + unitsConsumed);
        System.out.println("Bill       : ₹" + calculateBill());
        System.out.println();
    }
}

public class ElectricVehicleChargingNetwork {
    public static void main(String[] args) {

        ChargingStation s1 = new ChargingStation(1, 100);
        ChargingStation s2 = new ChargingStation(2, 120);
        ChargingStation s3 = new ChargingStation(3, 90);
        ChargingStation s4 = new ChargingStation(4, 150);
        ChargingStation s5 = new ChargingStation(5, 200);

        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        System.out.println("Total Stations = " +
                ChargingStation.totalStations);

        ChargingStation.electricityRate = 10.0;

        System.out.println("\nAfter Rate Change:");

        s1.displayStationDetails();
        s2.displayStationDetails();
    }
}