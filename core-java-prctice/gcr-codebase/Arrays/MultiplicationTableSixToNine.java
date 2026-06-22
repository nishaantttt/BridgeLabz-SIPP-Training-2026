import java.util.Scanner;

// Program to generate multiplication table from 6 to 9
class MultiplicationTableSixToNine {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid input.");
            input.close();
            return;
        }

        int number = input.nextInt();

        // Array size for 6,7,8,9
        int[] multiplicationResult = new int[4];

        int arrayIndex = 0;

        // Store results
        for (int multiplier = 6; multiplier <= 9; multiplier++) {

            multiplicationResult[arrayIndex] =
                    number * multiplier;

            arrayIndex++;
        }

        // Display results
        arrayIndex = 0;

        for (int multiplier = 6; multiplier <= 9; multiplier++) {

            System.out.println(number + " * " +
                    multiplier + " = " +
                    multiplicationResult[arrayIndex]);

            arrayIndex++;
        }

        input.close();
    }
}