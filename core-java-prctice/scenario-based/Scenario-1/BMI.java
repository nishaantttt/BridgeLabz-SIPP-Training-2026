import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input height in meters
        System.out.print("Enter height (in meters): ");
        double height = sc.nextDouble();

        // Input weight in kilograms
        System.out.print("Enter weight (in kg): ");
        double weight = sc.nextDouble();

        // Calculate BMI
        double bmi = weight / (height * height);

        // Display BMI
        System.out.println("BMI = " + bmi);

        // Determine BMI category
        if (bmi < 18.5) {
            System.out.println("Category: Underweight");
        } else if (bmi < 25) {
            System.out.println("Category: Normal");
        } else {
            System.out.println("Category: Overweight");
        }
        sc.close();
    }
}