import java.util.*;

abstract class CourseType {

    String courseName;

    CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String toString() {
        return courseName;
    }
}

class ExamCourse extends CourseType {
    ExamCourse(String name) {
        super(name);
    }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String name) {
        super(name);
    }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String name) {
        super(name);
    }
}

class Course<T extends CourseType> {

    List<T> list = new ArrayList<>();

    void add(T course) {
        list.add(course);
    }

    List<T> getCourses() {
        return list;
    }
}

public class CourseDemo {

    static void display(List<? extends CourseType> list) {

        for (CourseType c : list)
            System.out.println(c);
    }

    public static void main(String[] args) {

        Course<ExamCourse> exam = new Course<>();

        exam.add(new ExamCourse("Java Programming"));

        display(exam.getCourses());
    }
}