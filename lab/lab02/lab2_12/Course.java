package lab2_12;

public class Course {
    
    private String courseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseInfo() {
        return this.courseId + ": " + this.courseName;
    }
}