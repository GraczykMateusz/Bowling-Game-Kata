package pl.graczykmateusz.BowlingGameKata;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
    boolean isGameOver = false;
    

    @Override
    public void roll(int pins) {
        if (isGameOver) {

        } else {
            throw new IllegalStateException("Cannot roll when the game is over!");
        }
    }

    @Override
    public int score() {

    }

    private boolean checkIfIsStrike(int pins) {

    }

    private boolean checkIfIsSpare() {

    }

    private void checkIfPinsAreValid(int pins) {
        if (pins < 0)
            throw new IllegalArgumentException("Pins cannot be smaller then 0");
        if (pins > 10)
            throw  new IllegalArgumentException("Pins cannot be greater then 10");
    }
}
