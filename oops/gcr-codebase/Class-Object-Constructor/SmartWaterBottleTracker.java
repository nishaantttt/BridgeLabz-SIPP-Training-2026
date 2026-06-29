class WaterBottle {

    private String ownerName;
    private int dailyTarget;

    public WaterBottle(String ownerName, int dailyTarget) {
        this.ownerName = ownerName;
        this.dailyTarget = dailyTarget;
    }

    public void displayBottleInfo() {
        System.out.println("Owner Name : " + ownerName);
        System.out.println("Daily Target : " + dailyTarget + " ml");
        System.out.println();
    }
}

public class SmartWaterBottleTracker {
    public static void main(String[] args) {

        WaterBottle bottle1 = new WaterBottle("Mayank", 3000);
        WaterBottle bottle2 = new WaterBottle("Ravi", 2500);

        bottle1.displayBottleInfo();
        bottle2.displayBottleInfo();
    }
}