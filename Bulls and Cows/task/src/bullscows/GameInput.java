package bullscows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameInput {

    private static final Scanner sc = new Scanner(System.in);

    private int secretLength;

    private int numberOfSymbols;

    private String guess;
    protected int getSecretLength() {
        return secretLength;
    }

    protected int getNumberOfSymbols() {
        return numberOfSymbols;
    }

    protected String getGuess() {
        return guess;
    }

    protected void setSecretLength() {
        System.out.println("Input the length of the secret code (1-36):");
            secretLength = sc.nextInt();
    }

    protected void setNumberOfSymbols() {
        System.out.println("Input the number of possible symbols in the code:");
        numberOfSymbols = sc.nextInt();
    }

    protected int setGuess(int turn) {
        System.out.printf("Turn %d\n", turn);
        turn++;
        this.guess = sc.next();
        return turn;
    }
}
