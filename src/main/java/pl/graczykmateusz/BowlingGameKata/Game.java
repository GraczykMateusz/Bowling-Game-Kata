package pl.graczykmateusz.BowlingGameKata;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
    List<Integer> rolls = new ArrayList<>();
    int score = 0;
    int rollIndex = 0;

    @Override
    public void roll(int pin) {
        checkPinValidation(pin);
        rolls.add(pin);
    }

    @Override
    public int score() {
        return calculateScore();
    }

    int calculateScore() {
        final int framesCount = 10;
        for (int i = 0; i < framesCount; i++) {
            if (checkIfIsStrike()) {
                score += 10 + rolls.get(rollIndex + 1) + rolls.get(rollIndex + 2);
                rollIndex++;
            } else if (checkIfIsSpare()) {
                score += 10 + rolls.get(rollIndex + 2);
                rollIndex += 2;
            } else {
                score += rolls.get(rollIndex) + rolls.get(rollIndex + 1);
                rollIndex += 2;
            }
        }
        return score;
    }

    boolean checkIfIsStrike() {
        return rolls.get(rollIndex) == 10;
    }

    boolean checkIfIsSpare() {
        return rolls.get(rollIndex) + rolls.get(rollIndex + 1) == 10;
    }

    void checkPinValidation(int pin) {
        if (pin < 0)
            throw new IllegalArgumentException("Pins cannot be smaller then 0");
        if (pin > 10)
            throw  new IllegalArgumentException("Pins cannot be greater then 10");
    }
}
