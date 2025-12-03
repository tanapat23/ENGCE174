package lab2_2;

public class Student {
    
    private String studentId;
    private String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public void displayInfo() {
        System.out.println(this.studentId);
        System.out.println(this.name);
    }
}