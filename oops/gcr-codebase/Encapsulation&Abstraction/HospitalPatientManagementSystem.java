abstract class Patient {

    private int patientId;
    private String name;
    private int age;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract double calculateBill();

    public void displayPatientDetails() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
    }
}

class InPatient extends Patient {

    private double roomCharges;
    private double treatmentCharges;

    public void setRoomCharges(double roomCharges) {
        this.roomCharges = roomCharges;
    }

    public void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    public double calculateBill() {
        return roomCharges + treatmentCharges;
    }
}

class OutPatient extends Patient {

    private double consultationFees;
    private double treatmentCharges;

    public void setConsultationFees(double consultationFees) {
        this.consultationFees = consultationFees;
    }

    public void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    public double calculateBill() {
        return consultationFees + treatmentCharges;
    }
}

public class HospitalPatientManagementSystem {
    public static void main(String[] args) {

        InPatient inPatient = new InPatient();
        inPatient.setPatientId(201);
        inPatient.setName("Mayank");
        inPatient.setAge(21);
        inPatient.setRoomCharges(5000);
        inPatient.setTreatmentCharges(12000);

        OutPatient outPatient = new OutPatient();
        outPatient.setPatientId(202);
        outPatient.setName("Ravi");
        outPatient.setAge(25);
        outPatient.setConsultationFees(500);
        outPatient.setTreatmentCharges(2500);

        inPatient.displayPatientDetails();
        System.out.println("Bill : ₹" +
                inPatient.calculateBill());

        System.out.println();

        outPatient.displayPatientDetails();
        System.out.println("Bill : ₹" +
                outPatient.calculateBill());
    }
}