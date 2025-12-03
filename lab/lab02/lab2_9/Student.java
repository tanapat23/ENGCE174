package lab2_9;

public class Student {
    
    private String name;
    private Address address;

    public Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void displayProfile() {
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address.getFullAddress());
    }
}