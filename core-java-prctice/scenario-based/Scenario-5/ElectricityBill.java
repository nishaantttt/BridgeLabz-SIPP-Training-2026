import java.util.Scanner;

public class ElectricityBill {

    public static int acceptUnits() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter units consumed: ");
        return sc.nextInt();
    }

    public static double calculateBill(int units) {
        double rate = 5.0;
        return units * rate;
    }

    public static void displayBill(int units, double bill) {
        System.out.println("Units Consumed: " + units);
        System.out.println("Bill Amount: ₹" + bill);
    }

    public static void main(String[] args) {
        int units = acceptUnits();
        double bill = calculateBill(units);
        displayBill(units, bill);
    }
    
}