import java.util.Scanner;

public class KingdomTax {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] income = new double[10];
        double totalTax = 0;

        for (int i = 0; i < 10; i++) {

            System.out.print("Enter income of citizen " + (i + 1) + ": ");
            income[i] = sc.nextDouble();

            double tax = 0;
            String bracket;

            if (income[i] < 10000) {
                bracket = "5% Tax Bracket";
                tax = income[i] * 0.05;
            } else if (income[i] <= 50000) {
                bracket = "15% Tax Bracket";
                tax = income[i] * 0.15;
            } else {
                bracket = "30% Tax Bracket";
                tax = income[i] * 0.30;
            }

            System.out.println("Tax Bracket : " + bracket);
            System.out.println("Tax Amount  : " + tax);
            System.out.println();

            totalTax += tax;
        }
        System.out.println("Total Tax Collected = " + totalTax);

        sc.close();
    }
}