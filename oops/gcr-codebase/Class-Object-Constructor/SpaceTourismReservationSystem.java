class SpaceTourist {

    static int totalReservations = 0;
    static String missionName = "Mars Explorer 1";

    private String touristName;
    private int seatNumber;

    public SpaceTourist(String touristName, int seatNumber) {
        this.touristName = touristName;
        this.seatNumber = seatNumber;
        totalReservations++;
    }

    public SpaceTourist updateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public void displayDetails() {
        System.out.println("Mission Name : " + missionName);
        System.out.println("Tourist Name : " + touristName);
        System.out.println("Seat Number  : " + seatNumber);
        System.out.println();
    }
}

public class SpaceTourismReservationSystem {
    public static void main(String[] args) {

        SpaceTourist tourist1 =
                new SpaceTourist("Mayank", 5);

        tourist1.updateSeatNumber(10)
                .updateSeatNumber(15);

        tourist1.displayDetails();

        System.out.println(
                "Total Reservations : "
                + SpaceTourist.totalReservations);
    }
}