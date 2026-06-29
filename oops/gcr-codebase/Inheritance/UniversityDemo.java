class Person {

    protected String name;
    protected int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               ", Age: " + age;
    }
}

class Student extends Person {

    private final int studentId;
    protected double gpa;

    Student(String name, int age,
            int studentId, double gpa) {

        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Student ID: " + studentId +
               ", GPA: " + gpa;
    }
}

class GradStudent extends Student {

    private String thesis;

    GradStudent(String name, int age,
                int studentId,
                double gpa,
                String thesis) {

        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Thesis: " + thesis;
    }
}

public class UniversityDemo {

    public static void main(String[] args) {

        GradStudent gs =
                new GradStudent(
                        "Mayank",
                        22,
                        101,
                        9.2,
                        "Artificial Intelligence");

        System.out.println(gs);

        System.out.println(
                gs instanceof Student);

        System.out.println(
                gs instanceof Person);
    }
}