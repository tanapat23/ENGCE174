package lab4;

import java.util.Scanner;

class ScoreBoard {

    private final String gameName;
    private final int[] scores;

    // Main Constructor → Shallow Copy
    public ScoreBoard(String gameName, int[] scores) {
        this.gameName = gameName;
        this.scores = scores; // shallow copy
    }

    // Copy Constructor → Deep Copy
    public ScoreBoard(ScoreBoard other) {
        this.gameName = other.gameName;
        this.scores = new int[other.scores.length];
        for (int i = 0; i < other.scores.length; i++) {
            this.scores[i] = other.scores[i];
        }
    }

    public void displayScores() {
        System.out.print(this.gameName + ": ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]);
            if (i < scores.length - 1)
                System.out.print(", ");
        }
        System.out.println();
    }
}

public class CopyScoreBoard {

    // Validation 1 check input type
    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input type. Please enter an integer.");
                sc.next();
                continue;
            }
            return sc.nextInt();
        }
    }

    // Validation 2 check non-negative
    private static int validateScore(int score) {
        if (score < 0) {
            System.out.println("Score cannot be negative. Set to 0.");
            return 0;
        }
        return score;
    }

    // Prompt for String
    private static String readString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.next();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input with prompts
        String name = readString(sc, "Enter game name: ");

        int s1 = validateScore(readInt(sc, "Enter score #1: "));
        int s2 = validateScore(readInt(sc, "Enter score #2: "));
        int s3 = validateScore(readInt(sc, "Enter score #3: "));

        // Step 1: Create original array
        int[] originalScores = { s1, s2, s3 };

        // Step 2: sb1 (shallow copy)
        ScoreBoard sb1 = new ScoreBoard(name, originalScores);

        // Step 3: sb2 (deep copy)
        ScoreBoard sb2 = new ScoreBoard(sb1);

        // NEW: Ask user what to change originalScores[0] to
        int newValue = validateScore(readInt(sc, "Enter new value for originalScores[0]: "));
        originalScores[0] = newValue;

        // Step 5: Display sb1 (affected)
        sb1.displayScores();

        // Step 6: Display sb2 (unaffected)
        sb2.displayScores();

        sc.close();
    }
}
