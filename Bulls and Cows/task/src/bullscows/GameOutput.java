package bullscows;

public class GameOutput {

    protected void secretIsPrepared(int secretLength, int numberOfSymbols) {
        StringBuilder stars = new StringBuilder();
        stars.append("*".repeat(secretLength));
        stars.append(" (0-");
        if (numberOfSymbols <= 10) {
            stars.append(numberOfSymbols-1);
        } else {
            stars.append("9, a");
        }
        if (numberOfSymbols > 11) {
            stars.append("-");
            stars.append((char) (numberOfSymbols + 86));
        }
        stars.append(")");
        System.out.printf("The secret is prepared: %s.\n", stars);
    }

    protected void outputLetsStart() {
        System.out.println("Okay, let's start a game!");
    }

    protected boolean printOutput(int bulls, int cows, Secret secret, boolean guessed) {
        if (bulls == secret.getSecret().length()) {
            System.out.printf("Grade: %d bulls\nCongratulations! You guessed the secret code.\n", bulls);
            guessed = true;
        } else if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s)\n", bulls, cows);
        } else if (bulls > 0) {
            System.out.printf("Grade: %d bull(s)\n", bulls);
        } else if (cows > 0) {
            System.out.printf("Grade: %d cow(s)\n", cows);
        } else {
            System.out.println("Grade: None");
        }
        return guessed;
    }
}
