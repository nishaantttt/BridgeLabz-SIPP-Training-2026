import java.util.Scanner;

// Program to store numbers and find sum
class StoreAndSumNumbers {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Maximum array size
        final int MAX_SIZE = 10;

        // Array declaration
        double[] numbers = new double[MAX_SIZE];

        // Variables
        int index = 0;
        double total = 0.0;

        // Infinite loop
        while (true) {

            if (index == numbers.length) {
                break;
            }

            System.out.print("Enter a positive number: ");

            if (!input.hasNextDouble()) {
                System.out.println("Invalid input.");
                input.close();
                return;
            }

            double userNumber = input.nextDouble();

            if (userNumber <= 0) {
                break;
            }

            numbers[index] = userNumber;
            index++;
        }

        // Display numbers and calculate sum
        System.out.println("\nNumbers Entered:");

        for (int counter = 0; counter < index; counter++) {
            System.out.println(numbers[counter]);
            total += numbers[counter];
        }

        System.out.println("\nSum = " + total);

        input.close();
    }
}