import java.util.*;
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println("Factorial of " + N + " = " + factorial(N));
        sc.close();
    }
    public static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }

        return n*factorial(n-1);
    }
}
