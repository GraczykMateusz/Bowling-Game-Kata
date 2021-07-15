package pl.graczykmateusz.BowlingGameKata;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
    int round = 1;
    int roll = 1;
    final int rollLimitPerRound = 2;

    List<List<Integer>> scorePerFrames = new ArrayList<>();
    List<Integer> scorePerFrame = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    final int strike = 10;
    final int spare = 10;

    boolean wasStrike = false;

    boolean isStrike = false;
    boolean isSpare = false;

    @Override
    public void roll(int pins) {
        scorePerFrame.add(pins);
        if (roll % rollLimitPerRound == 0) {
            updateScoreFrames();
            resetRollCount();
            nextRound();
        }
        nextRoll();
    }

    @Override
    public int score() {
        return scorePerFrames.stream()
                .flatMap(List::stream)
                .reduce(Integer::sum)
                .orElse(-1);
    }

    private void nextRound() {
        round++;
    }

    private void nextRoll() {
        roll++;
    }

    private void resetRollCount() {
        roll = 1;
    }

    private void updateScoreFrames() {
        scorePerFrames.add(new ArrayList<>(scorePerFrame));
        scorePerFrame.clear();
    }

    private void strike() {
//        if (round != 1) {
//            scorePerFrame.add(strike);
//        }
//        scorePerFrames.add(new ArrayList<>(scorePerFrame));
    }

    private void spare() {

    }
}
