import java.util.HashSet;

public class EventEntryVerificationSystem {

    static HashSet<String> participants = new HashSet<>();

    static void register(String email) {
        if (participants.add(email))
            System.out.println("Registration Successful: " + email);
        else
            System.out.println("Duplicate Registration Rejected.");
    }

    static void displayParticipants() {
        System.out.println("\nRegistered Participants:");

        for (String email : participants)
            System.out.println(email);

        System.out.println("Total Attendees: " + participants.size());
    }

    public static void main(String[] args) {

        register("nishant@gmail.com");
        register("aman@gmail.com");
        register("rahul@gmail.com");
        register("aman@gmail.com");

        displayParticipants();
    }
}