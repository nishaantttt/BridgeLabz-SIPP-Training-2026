import java.util.HashSet;
import java.util.Set;

public class DuplicateSessionTokenDetection {

    public static boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();

        for (String token : tokens) {
            if (!seen.add(token)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] tokens = {
                "abc123", "xyz456", "hello789",
                "abc123", "java001"
        };

        if (hasDuplicateToken(tokens)) {
            System.out.println("Duplicate token found.");
        } else {
            System.out.println("No duplicate tokens.");
        }
    }
}