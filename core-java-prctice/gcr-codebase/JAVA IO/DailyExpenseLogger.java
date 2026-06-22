import java.io.*;
import java.util.*;

public class DailyExpenseLogger {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Expense Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Amount: ");
        int amount = sc.nextInt();

        try {
            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter("expenses.txt", true));

            bw.write(category + " - " + amount);
            bw.newLine();

            bw.close();

            System.out.println("Expense saved.");

        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }
}