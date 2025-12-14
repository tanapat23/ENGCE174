package Lab_3.Lab_3_3 ;

import java.util.Scanner ;

class User {
    private String password ;

    public User(String initialPassword) {
        password = initialPassword ;
    }

    public String getPassword() {
        return password ;
    }

    public void setPassword(String newPassword) {
        if (newPassword.length() >= 8) {
            password = newPassword ;
            System.out.println("Password updated.") ;
        } else {
            System.out.println("Password is too short.") ;
        }
    }
}

public class Lab_3_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;

        System.out.print("Enter Initial Password : ") ;
        String startPass = input.nextLine() ;

        System.out.print("Enter New Password : ") ;
        String newPass = input.nextLine() ;

        User myUser = new User(startPass) ;

        myUser.setPassword(newPass) ;

        System.out.println(myUser.getPassword()) ;

        input.close() ;
    }
}
