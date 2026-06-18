import java.util.Scanner;

public class CoffeeCafe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter coffee type (Espresso/Cappuccino/Latte) or exit: ");
            String coffee = sc.nextLine();

            if (coffee.equalsIgnoreCase("exit")) {
                break;
            }

            double price = 0;

            switch (coffee.toLowerCase()) {
                case "espresso":
                    price = 120;
                    break;
                case "cappuccino":
                    price = 150;
                    break;
                case "latte":
                    price = 180;
                    break;
                default:
                    System.out.println("Invalid coffee type");
                    continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            double bill = price * quantity;
            double gst = bill * 0.18;
            double total = bill + gst;

            System.out.println("Bill Amount: ₹" + bill);
            System.out.println("GST: ₹" + gst);
            System.out.println("Total Payable: ₹" + total);
            System.out.println();
        }

        System.out.println("Cafe Closed");
        sc.close();
    }
}