package bullscows;

public class GameLogic {

    private int bulls;
    private int cows;

    protected int getBulls() {
        return bulls;
    }

    protected int getCows() {
        return cows;
    }

    protected void checkCode(String secretNum, String guessNum) {
        bulls = 0;
        cows = 0;
        for (int i = 0; i < secretNum.length(); i++) {
            char guessChar = guessNum.charAt(i);
            char secretChar = secretNum.charAt(i);
            if (guessChar == secretChar) {
                bulls++;
            }
            for (int j = 0; j < secretNum.length(); j++) {
                secretChar = secretNum.charAt(j);
                if (guessChar == secretChar) {
                    cows++;
                }
            }
        }
        cows -= bulls;
    }
}
