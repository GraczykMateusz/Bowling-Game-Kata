package pl.graczykmateusz.BowlingGameKata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BowlingGameKataApplicationTests {
	Game game;
	final int rounds = 20;

	@BeforeEach
	void setup() {
		game = new Game();
	}

	@Test
	void shouldScoreEqualsZeroWhenMissAllRounds() {
		final int expected = 0;
		final int pins = 0;

		for (int i = 0; i < rounds; i++) {
			game.roll(pins);
		}
		int actual = game.score();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void shouldScoreEqualsThreeHundredWhenRolledAllPinsAllRounds() {
		final int expected = 300;
		final int pins = 10;

		for (int i = 0; i < rounds; i++) {
			game.roll(pins);
		}
		int actual = game.score();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void shouldScoreEqualsSumOfPinsWhenNoRolledAnyBonusPerRound() {
		final int expected = 40;
		final int pins = 2;

		for (int i = 0; i < rounds; i++) {
			game.roll(pins);
		}
		int actual = game.score();
		Assertions.assertEquals(expected, actual);
	}
}
