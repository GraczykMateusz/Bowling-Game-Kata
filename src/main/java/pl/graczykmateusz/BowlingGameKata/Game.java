package pl.graczykmateusz.BowlingGameKata;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
    boolean isGameOver = false;
    int score = 0;

    List<List<Integer>> scorePerFrames = new ArrayList<>();
    List<Integer> scores = new ArrayList<>();

    @Override
    public void roll(int pins) {
        if (!isGameOver) {
            checkIfPinsAreValid(pins);
            if (checkIfIsStrike()) {

            } else if (checkIfIsSpare()) {

            } else {
                score += pins;
            }
        } else {
            throw new IllegalStateException("Cannot roll when the game is over!");
        }
    }

    @Override
    public int score() {
        return score;
    }

    private boolean checkIfIsStrike() {
        return false;
    }

    private boolean checkIfIsSpare() {
        return false;
    }

    private void checkIfPinsAreValid(int pins) {
        if (pins < 0)
            throw new IllegalArgumentException("Pins cannot be smaller then 0");
        if (pins > 10)
            throw  new IllegalArgumentException("Pins cannot be greater then 10");
    }
}
