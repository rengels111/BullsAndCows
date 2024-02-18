package bullscows;

import java.util.InputMismatchException;

public class GameFlow {

    private boolean guessed = false;
    private int turn = 1;


    GameInput input = new GameInput();
    Secret secret = new Secret();
    GameLogic logic =  new GameLogic();
    GameOutput output = new GameOutput();


    protected void run() {
        try {
            input.setSecretLength();
            if (input.getSecretLength() < 1 || input.getSecretLength()> 36) {
                System.out.println("Error: The code length must be between 1-36!");
            } else {
                input.setNumberOfSymbols();
                if (input.getNumberOfSymbols() < 1 || input.getNumberOfSymbols() > 36) {
                    System.out.println("Error: The number of possible symbols in the code is 1-36 (0-9, a-z)!");
                } else {
                    if (input.getNumberOfSymbols() < input.getSecretLength()) {
                        System.out.println("Error: The number of symbols must be a minimum of the code length.");
                    } else {
                        secret.createSecret(input.getSecretLength(), input.getNumberOfSymbols());
                        output.secretIsPrepared(input.getSecretLength(), input.getNumberOfSymbols());
                        output.outputLetsStart();
                        while (!guessed) {
                            turn = input.setGuess(turn);
                            logic.checkCode(secret.getSecret(), input.getGuess());
                            guessed = output.printOutput(logic.getBulls(), logic.getCows(), secret, guessed);
                        }
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input!");
        }

    }
}
