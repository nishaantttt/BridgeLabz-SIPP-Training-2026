import java.util.Scanner;

public class Descending {
    public static void printDescending(int n) {
        if (n == 0) {   // Base case
            return;
        }

        System.out.print(n + " ");
        printDescending(n - 1); // Recursive call
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        printDescending(N);
        sc.close();
    }
}
