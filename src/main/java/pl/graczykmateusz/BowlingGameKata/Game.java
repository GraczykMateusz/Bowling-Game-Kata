package pl.graczykmateusz.BowlingGameKata;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
    boolean isGameOver = false;
    int rollsQueue = 1;
    int score = 0;

    int strikeBonus = 0;
    boolean isItSpareInSecondRoll = false;
    List<Integer> rollsHistory = new ArrayList<>();

    @Override
    public void roll(int pins) {
        if (rollsQueue == 21) {
            score += pins;
            rollsQueue++;
            isGameOver = true;
        }
        else if (!isGameOver) {
            checkIfPinsAreValid(pins);
            if (checkIfIsStrike(pins) && strikeBonus != 0) {
                strikeBonus = 2;
                if (rollsQueue <= 18) {
                    rollsQueue += 2;
                    score += 2 * pins;
                }
                else {
                    score += pins;
                    if (rollsHistory.size() > 1 && rollsQueue < 21) {
                        int sumTwoElements = rollsHistory.get(rollsHistory.size() - 1) + rollsHistory.get(rollsHistory.size() - 2);
                        if (sumTwoElements == 20) //
                            score += 10;
                    }
                    rollsQueue++;
                }
                if (rollsHistory.size() > 1 && rollsQueue < 21) {
                    int sumTwoElements = rollsHistory.get(rollsHistory.size() - 1) + rollsHistory.get(rollsHistory.size() - 2);
                    if (sumTwoElements == 20) //
                        score += 10;
                }
            }
            else if (pins != 10 && strikeBonus != 0) {
                if (strikeBonus == 2 && rollsQueue > 18) {
                    score += 2 * pins;
                }
                else if (strikeBonus == 2)
                    if (!rollsHistory.isEmpty()) {
                        if (rollsHistory.get(rollsHistory.size() - 1).equals(10)) {
                            score += 2 * pins;
                            if (rollsHistory.size() != 1) {
                                if (rollsHistory.get(rollsHistory.size() - 2).equals(10))
                                    score += pins;
                            }
                        }
                    } else
                        score += 3 * pins;
                if (strikeBonus == 1 && rollsQueue > 18) {
                    score += 2 * pins;
                }
                else if (strikeBonus == 1)
                    score += 2 * pins;
                strikeBonus--;
                rollsQueue++;
            }
            else if (checkIfIsStrike(pins) && !checkIfIsSpare()) {
                strikeBonus = 2;
                if (rollsQueue <= 18)
                    rollsQueue += 2;
                else
                    rollsQueue++;
                if (checkIfIsSpare() || isItSpareInSecondRoll) {
                    score += pins;
                    isItSpareInSecondRoll = false;
                }
                score += pins;
            } else if (checkIfIsSpare()) {
                isItSpareInSecondRoll = (rollsHistory.size() == 1 && rollsHistory.get(rollsHistory.size() - 1).equals(0));
                if (isItSpareInSecondRoll) {
                    score += pins;
                } else {
                    score += 2 * pins;
                    rollsHistory.clear();
                }
                rollsQueue++;
            } else {
                rollsQueue++;
                score += pins;
            }
            rollsHistory.add(pins);
        } else {
            throw new IllegalStateException("Cannot roll when the game is over!");
        }
    }

    @Override
    public int score() {
        return score;
    }

    private boolean checkIfIsStrike(int pins) {
        return pins == 10;
    }

    private boolean checkIfIsSpare() {
        if (rollsHistory.size() > 1) {
            if (!rollsHistory.get(rollsHistory.size() - 2).equals(0)) {
                int sumTwoElements = rollsHistory.get(rollsHistory.size() - 1) + rollsHistory.get(rollsHistory.size() - 2);
                if (sumTwoElements == 10) {
                    return true;
                }
            }
        }
        if (rollsHistory.size() == 1 && rollsHistory.get(rollsHistory.size() - 1).equals(0))
            return true;
        return false;
    }

    private void checkIfPinsAreValid(int pins) {
        if (pins < 0)
            throw new IllegalArgumentException("Pins cannot be smaller then 0");
        if (pins > 10)
            throw  new IllegalArgumentException("Pins cannot be greater then 10");
    }
}
