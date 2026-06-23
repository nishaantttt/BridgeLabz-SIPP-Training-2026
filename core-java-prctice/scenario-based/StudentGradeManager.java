import java.io.*;
import java.util.*;

public class StudentGradeManager {

    // Maximum number of students
    static final int MAX_STUDENTS = 100;

    // Arrays to store student data
    static String[] names = new String[MAX_STUDENTS];
    static int[][] marks = new int[MAX_STUDENTS][5];
    static int[] totals = new int[MAX_STUDENTS];
    static double[] averages = new double[MAX_STUDENTS];
    static String[] grades = new String[MAX_STUDENTS];

    static int studentCount = 0;

    // Read student data from file
    public static void readStudentData(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length != 6) {
                    System.out.println("Invalid record skipped.");
                    continue;
                }

                names[studentCount] = data[0];

                int total = 0;

                for (int i = 0; i < 5; i++) {

                    int mark = Integer.parseInt(data[i + 1]);

                    if (mark < 0 || mark > 100) {
                        throw new IllegalArgumentException(
                                "Marks should be between 0 and 100.");
                    }

                    marks[studentCount][i] = mark;
                    total += mark;
                }

                totals[studentCount] = total;
                averages[studentCount] = total / 5.0;
                grades[studentCount] =
                        calculateGrade(averages[studentCount]);

                studentCount++;
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric data in file.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Calculate grade using nested conditions
    public static String calculateGrade(double avg) {

        if (avg >= 90) {
            return "A+";
        } else {
            if (avg >= 80) {
                return "A";
            } else {
                if (avg >= 70) {
                    return "B";
                } else {
                    if (avg >= 60) {
                        return "C";
                    } else {
                        if (avg >= 50) {
                            return "D";
                        } else {
                            return "F";
                        }
                    }
                }
            }
        }
    }

    // Search student by name
    public static void searchStudent(String studentName) {

        boolean found = false;

        for (int i = 0; i < studentCount; i++) {

            if (names[i].equalsIgnoreCase(studentName)) {

                System.out.println("\nStudent Found");
                System.out.println("Name: " + names[i]);
                System.out.println("Total: " + totals[i]);
                System.out.println("Average: " + averages[i]);
                System.out.println("Grade: " + grades[i]);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Bubble sort by total marks (descending)
    public static void bubbleSortByTotal() {

        for (int i = 0; i < studentCount - 1; i++) {

            for (int j = 0; j < studentCount - i - 1; j++) {

                if (totals[j] < totals[j + 1]) {

                    // Swap names
                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;

                    // Swap totals
                    int tempTotal = totals[j];
                    totals[j] = totals[j + 1];
                    totals[j + 1] = tempTotal;

                    // Swap averages
                    double tempAvg = averages[j];
                    averages[j] = averages[j + 1];
                    averages[j + 1] = tempAvg;

                    // Swap grades
                    String tempGrade = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = tempGrade;

                    // Swap marks
                    int[] tempMarks = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = tempMarks;
                }
            }
        }
    }

    // Write report to output file
    public static void writeReport(String outputFile) {

        try {

            BufferedWriter bw =
                    new BufferedWriter(new FileWriter(outputFile));

            bw.write("STUDENT REPORT\n");
            bw.write("------------------------------------------\n");

            for (int i = 0; i < studentCount; i++) {

                bw.write("Name : " + names[i]);
                bw.write("\nTotal : " + totals[i]);
                bw.write("\nAverage : " +
                        String.format("%.2f", averages[i]));
                bw.write("\nGrade : " + grades[i]);
                bw.write("\n------------------------------------------\n");
            }

            bw.close();

            System.out.println(
                    "Report successfully written to " + outputFile);

        } catch (IOException e) {
            System.out.println(
                    "Error writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        readStudentData("students.txt");

        bubbleSortByTotal();

        System.out.print("Enter student name to search: ");
        String searchName = scanner.nextLine();

        searchStudent(searchName);

        writeReport("report.txt");

        scanner.close();
    }
}