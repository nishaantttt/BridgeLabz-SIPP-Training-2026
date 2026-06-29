interface Trackable {

    void logActivity();

    default void resetData() {
        System.out.println("Activity data reset");
    }
}

interface Reportable {

    void generateReport();
}

interface Notifiable {

    void sendAlert();
}

class FitnessDevice implements Trackable,
                               Reportable,
                               Notifiable {

    @Override
    public void logActivity() {
        System.out.println("Steps and calories logged");
    }

    @Override
    public void generateReport() {
        System.out.println("Weekly fitness report generated");
    }

    @Override
    public void sendAlert() {
        System.out.println("Workout reminder sent");
    }
}

public class FitnessTrackerDemo {

    public static void main(String[] args) {

        FitnessDevice device = new FitnessDevice();

        device.logActivity();
        device.generateReport();
        device.sendAlert();
        device.resetData();
    }
}