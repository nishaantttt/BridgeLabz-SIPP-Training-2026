public class ValidUsername {
    public static boolean isValidUsername(String str, int index) {
        if (index == str.length()) {
            return true;
        }

        char ch = str.charAt(index);

        if (ch < 'a' || ch > 'z') {
            return false;
        }

        return isValidUsername(str, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(isValidUsername("abcdxyz", 0));
        System.out.println(isValidUsername("abcD123", 0));
    }
}