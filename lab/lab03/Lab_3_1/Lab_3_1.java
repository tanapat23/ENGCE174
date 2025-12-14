package Lab_3.Lab_3_1 ;

import java.util.Scanner ;

class User {

    private String username ;

    public User(String username) {
        this.username = username ;
    }

    public String getUsername() {
        return username ;
    }
}

public class Lab_3_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;

        System.out.print("Enter Username : ") ;
        String name = input.nextLine() ;

        User newUser = new User(name) ;

               System.out.println(newUser.getUsername());

        input.close();
    }
}