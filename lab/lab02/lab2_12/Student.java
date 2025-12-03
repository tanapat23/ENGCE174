package lab2_12;
public class Student {
    
    private String studentName;
    private Course enrolledCourse;

    public Student(String studentName, Course enrolledCourse) {
        this.studentName = studentName;
        this.enrolledCourse = enrolledCourse;
    }

    public void displayEnrollment() {
        System.out.println("Student: " + this.studentName);
        System.out.println("Enrolled in: " + this.enrolledCourse.getCourseInfo());
    }
}