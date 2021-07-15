package pl.graczykmateusz.BowlingGameKata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game implements IGame {
    int round = 1;
    final int rollPerRound = 2;

    List<List<Integer>> scorePerFrames = new ArrayList<>();
    List<Integer> scorePerFrame = new ArrayList<>();

    final int strike = 10;
    final int spare = 10;

    boolean isStrike = false;
    boolean isSpare = false;

    @Override
    public void roll(int pins) {
        scorePerFrame.add(pins);

        if (round % rollPerRound == 0) {
            scorePerFrames.add(scorePerFrame.stream().collect(Collectors.toList()));
            scorePerFrame.clear();
        }
        nextRound();
    }

    @Override
    public int score() {
        return scorePerFrames.stream()
                .flatMap(List::stream)
                .reduce(Integer::sum)
                .get();
    }

    private void nextRound() {
        round++;
    }

    private boolean checkStrike(int pins) {
        if (pins == strike) {
            return true;
        }
        return false;
    }

    private void strike(int pins) {
//        temp.add(pins);
//        nextRound();
    }
}
