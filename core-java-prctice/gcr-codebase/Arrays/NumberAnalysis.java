import java.util.Scanner;

// Program to analyze numbers
class NumberAnalysis {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Array size
        final int ARRAY_SIZE = 5;

        // Array declaration
        int[] numbers = new int[ARRAY_SIZE];

        // Input numbers
        for (int index = 0; index < numbers.length; index++) {

            System.out.print("Enter number " + (index + 1) + ": ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input.");
                input.close();
                return;
            }

            numbers[index] = input.nextInt();
        }

        // Analyze numbers
        System.out.println("\nAnalysis:");

        for (int index = 0; index < numbers.length; index++) {

            if (numbers[index] > 0) {

                if (numbers[index] % 2 == 0) {
                    System.out.println(numbers[index] +
                            " is Positive and Even");
                } else {
                    System.out.println(numbers[index] +
                            " is Positive and Odd");
                }

            } else if (numbers[index] < 0) {
                System.out.println(numbers[index] +
                        " is Negative");
            } else {
                System.out.println(numbers[index] +
                        " is Zero");
            }
        }

        // Compare first and last element
        int firstElement = numbers[0];
        int lastElement = numbers[numbers.length - 1];

        if (firstElement == lastElement) {
            System.out.println("\nFirst and Last elements are Equal");
        } else if (firstElement > lastElement) {
            System.out.println("\nFirst element is Greater");
        } else {
            System.out.println("\nFirst element is Less");
        }

        input.close();
    }
}