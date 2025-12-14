package Lab_3.Lab_3_2 ;

import java.util.Scanner ;

class Player {
    private int score ;

    public Player(int initialScore) {
        this.score = initialScore ;
    }

    public int getScore() {
        return score ;
    }

    public void setScore(int newScore) {
        score = newScore ;
    }
}

public class Lab_3_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;

        System.out.print("Enter Initial Score : ") ;
        int initialScore = input.nextInt() ;

        System.out.print("Enter New Score : ") ;
        int newScore = input.nextInt() ;

        Player player = new Player(initialScore) ;

        player.setScore(newScore) ;

               System.out.println("Player score : " + player.getScore()) ;

        input.close() ;
    }
}