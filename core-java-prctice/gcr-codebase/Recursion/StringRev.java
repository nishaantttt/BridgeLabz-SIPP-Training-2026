public class StringRev {
    public static String reverse(String str) {
        if (str.length() == 0 || str.length() == 1) { // Base case
            return str;
        }

        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "Hello";
        System.out.println("Reversed String: " + reverse(str));
    }
}