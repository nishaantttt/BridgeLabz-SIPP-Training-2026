import java.util.*;

abstract class JobRole {

    String role;

    JobRole(String role) {
        this.role = role;
    }

    public String toString() {
        return role;
    }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {

    T role;

    Resume(T role) {
        this.role = role;
    }

    void display() {
        System.out.println(role);
    }
}

public class ResumeDemo {

    static void screen(List<? extends JobRole> list) {

        for (JobRole r : list)
            System.out.println("Screening : " + r);
    }

    public static void main(String[] args) {

        Resume<SoftwareEngineer> resume =
                new Resume<>(new SoftwareEngineer());

        resume.display();

        List<JobRole> list = new ArrayList<>();

        list.add(new SoftwareEngineer());
        list.add(new DataScientist());
        list.add(new ProductManager());

        screen(list);
    }
}