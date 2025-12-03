package lab2_4;

public class Student {
    
    private String name;
    private int midtermScore;
    private int finalScore;

    public Student(String name, int midtermScore, int finalScore) {
        this.name = name;
        this.midtermScore = midtermScore;
        this.finalScore = finalScore;
    }

    public double calculateAverage() {
        return (this.midtermScore + this.finalScore) / 2.0; 
    }

    public void displaySummary() {
        double averageScore = this.calculateAverage();
        String status;
        
        if (averageScore >= 50.0) {
            status = "Pass";
        } else {
            status = "Fail";
        }
        
        System.out.println("Name: " + this.name);
        System.out.printf("Average Score: %.1f%n", averageScore);
        System.out.println("Status: " + status);
    }
}