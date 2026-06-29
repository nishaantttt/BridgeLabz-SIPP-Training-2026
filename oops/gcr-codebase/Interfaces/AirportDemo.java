interface LuggageScanner {

    boolean scanLuggage(String passengerName);

    default void displaySecurityGuidelines() {
        System.out.println("Do not carry prohibited items.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null &&
               passportNo.length() == 8;
    }
}

interface PassportVerifier {

    boolean verifyPassport(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Carry a valid passport.");
    }
}

class AirportSecuritySystem
        implements LuggageScanner, PassportVerifier {

    @Override
    public boolean scanLuggage(String passengerName) {
        return true;
    }

    @Override
    public boolean verifyPassport(String passportNo) {
        return LuggageScanner.isPassportNumberValid(passportNo);
    }

    @Override
    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }

    public void processPassengers(String[] names,
                                  String[] passports) {

        for (int i = 0; i < names.length; i++) {

            if (verifyPassport(passports[i]) &&
                scanLuggage(names[i])) {

                System.out.println(
                        names[i] + " -> Allowed to Board");
            } else {

                System.out.println(
                        names[i] + " -> Boarding Denied");
            }
        }
    }
}

public class AirportDemo {

    public static void main(String[] args) {

        String[] names = {
                "Rahul",
                "Aman",
                "Priya"
        };

        String[] passports = {
                "AB123456",
                "XYZ12",
                "CD789012"
        };

        AirportSecuritySystem system =
                new AirportSecuritySystem();

        system.displaySecurityGuidelines();
        System.out.println();

        system.processPassengers(names, passports);
    }
}