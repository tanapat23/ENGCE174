package lab2_3;

public class Student {
    
    private String studentId;
    private String name;
    
    public static int studentCount = 0;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        studentCount++;
    }
}