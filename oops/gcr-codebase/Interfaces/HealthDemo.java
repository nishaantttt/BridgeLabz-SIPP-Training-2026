interface HeartRateMonitor {

    void displayHeartRate();

    default void displayHealthTips() {
        System.out.println("Exercise regularly.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId != null &&
               patientId.startsWith("P") &&
               patientId.length() == 5;
    }
}

interface TemperatureMonitor {

    void displayTemperature();

    default void displayHealthTips() {
        System.out.println("Drink enough water.");
    }
}

class HealthMonitoringSystem
        implements HeartRateMonitor,
                   TemperatureMonitor {

    String[] names;
    String[] ids;

    HealthMonitoringSystem(String[] names,
                           String[] ids) {

        this.names = names;
        this.ids = ids;
    }

    @Override
    public void displayHeartRate() {

        int heartRate =
                60 + (int)(Math.random() * 40);

        System.out.println(
                "Heart Rate: " + heartRate + " BPM");
    }

    @Override
    public void displayTemperature() {

        double temp =
                97 + Math.random() * 3;

        System.out.printf(
                "Temperature: %.1f°F%n",
                temp);
    }

    @Override
    public void displayHealthTips() {

        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();
    }

    void generateReport() {

        for (int i = 0; i < names.length; i++) {

            System.out.println(
                    "\nPatient: " + names[i]);

            if (HeartRateMonitor
                    .isPatientIdValid(ids[i])) {

                System.out.println(
                        "Patient ID Valid");

                displayHeartRate();
                displayTemperature();

            } else {

                System.out.println(
                        "Invalid Patient ID");
            }
        }
    }
}

public class HealthDemo {

    public static void main(String[] args) {

        String[] names = {
                "Rahul",
                "Aman",
                "Priya"
        };

        String[] ids = {
                "P1001",
                "X2001",
                "P3002"
        };

        HealthMonitoringSystem system =
                new HealthMonitoringSystem(
                        names,
                        ids);

        system.displayHealthTips();

        System.out.println(
                "\n----- Health Report -----");

        system.generateReport();
    }
}