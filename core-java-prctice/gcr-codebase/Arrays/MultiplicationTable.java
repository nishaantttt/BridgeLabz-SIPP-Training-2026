import java.util.Scanner;

// Program to generate multiplication table
class MultiplicationTable {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid input.");
            input.close();
            return;
        }

        int number = input.nextInt();

        // Array to store results
        int[] multiplicationTable = new int[10];

        // Calculate table
        for (int index = 0; index < multiplicationTable.length; index++) {
            multiplicationTable[index] =
                    number * (index + 1);
        }

        // Display table
        System.out.println("\nMultiplication Table:");

        for (int index = 0; index < multiplicationTable.length; index++) {
            System.out.println(number + " * " +
                    (index + 1) + " = " +
                    multiplicationTable[index]);
        }

        input.close();
    }
}