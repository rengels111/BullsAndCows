package bullscows;

import java.util.*;

public class Secret {

    private String secret;
    private final List<Character> characters = new ArrayList<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z'));

    protected String getSecret() {
        return secret;
    }

    protected void createSecret(int secretLength, int numberOfSymbols) {
        List<Character> shortenedCharList = new ArrayList<>(characters.subList(0, numberOfSymbols));
        Collections.shuffle(shortenedCharList);

        StringBuilder randomNumsAndChars = new StringBuilder();
        for (char c : shortenedCharList) {
            randomNumsAndChars.append(c);
        }

        StringBuilder secretNum = new StringBuilder();
        int i = 0;
        while (secretNum.length() < secretLength) {
            secretNum.append(randomNumsAndChars.charAt(i));
            i++;
        }

        secret = secretNum.toString();
    }
}
