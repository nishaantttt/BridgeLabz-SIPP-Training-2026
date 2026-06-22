import java.util.Scanner;

// Program to check voting eligibility of 10 students
class StudentVotingEligibility {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Constant for total students
        final int TOTAL_STUDENTS = 10;

        // Array to store ages
        int[] studentAges = new int[TOTAL_STUDENTS];

        // Input ages
        for (int index = 0; index < studentAges.length; index++) {

            System.out.print("Enter age of student " + (index + 1) + ": ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Age must be an integer.");
                input.close();
                return;
            }

            studentAges[index] = input.nextInt();
        }

        // Check voting eligibility
        System.out.println("\nVoting Eligibility Report:");

        for (int index = 0; index < studentAges.length; index++) {

            if (studentAges[index] < 0) {
                System.out.println("Invalid age: " + studentAges[index]);
            } else if (studentAges[index] >= 18) {
                System.out.println("The student with age " +
                        studentAges[index] + " can vote.");
            } else {
                System.out.println("The student with age " +
                        studentAges[index] + " cannot vote.");
            }
        }

        input.close();
    }
}