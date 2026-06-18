import java.util.*;
public class Sumation {
    public static int sum(int n) {
        if (n == 1) { // Base case
            return 1;
        }

        return n + sum(n - 1); // Recursive call
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println("Sum = " + sum(N));
        sc.close();
    }
}