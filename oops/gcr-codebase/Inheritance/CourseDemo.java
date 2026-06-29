class Course {

    protected String courseName;
    protected int duration;

    Course(String courseName,
           int duration) {

        this.courseName = courseName;
        this.duration = duration;
    }

    void displayCourse() {

        System.out.println(
                "Course Name: " + courseName);

        System.out.println(
                "Duration: " + duration + " hours");
    }
}

class OnlineCourse extends Course {

    protected String platform;
    protected boolean isRecorded;

    OnlineCourse(String courseName,
                 int duration,
                 String platform,
                 boolean isRecorded) {

        super(courseName, duration);

        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayCourse() {

        super.displayCourse();

        System.out.println(
                "Platform: " + platform);

        System.out.println(
                "Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {

    private double fee;
    private double discount;

    PaidOnlineCourse(String courseName,
                     int duration,
                     String platform,
                     boolean isRecorded,
                     double fee,
                     double discount) {

        super(courseName,
              duration,
              platform,
              isRecorded);

        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void displayCourse() {

        super.displayCourse();

        System.out.println(
                "Fee: ₹" + fee);

        System.out.println(
                "Discount: " + discount + "%");

        System.out.println(
                "Final Fee: ₹" +
                (fee - fee * discount / 100));
    }
}

public class CourseDemo {

    public static void main(String[] args) {

        PaidOnlineCourse course =
                new PaidOnlineCourse(
                        "Java Full Stack",
                        120,
                        "Udemy",
                        true,
                        5000,
                        20);

        course.displayCourse();
    }
}