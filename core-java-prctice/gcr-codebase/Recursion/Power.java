public class Power {
    public static long power(int x, int n) {
        if (n == 0) { // Base case
            return 1;
        }

        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 5;

        System.out.println(x + "^" + n + " = " + power(x, n));
    }
}