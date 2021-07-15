package pl.graczykmateusz.BowlingGameKata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BowlingGameKataApplicationTests {
	Game game;

	@BeforeEach
	void setup() {
		game = new Game();
	}

	@Test
	void shouldScoreEqualsZeroWhenMissAllRounds() {
		final int expected = 0;
		final int rounds = 20;
		final int pins = 0;

		for (int i = 0; i < rounds; i++) {
			game.roll(pins);
		}
		int actual = game.score();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void shouldScoreEqualsThreeHundredWhenHitAllPinsAllRounds() {
		final int expected = 300;
		final int rounds = 20;
		final int pins = 10;

		for (int i = 0; i < rounds; i++) {
			game.roll(pins);
		}
		int actual = game.score();
		Assertions.assertEquals(expected, actual);
	}
}
