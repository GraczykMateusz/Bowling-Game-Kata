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

		for (int i = 0; i < rounds; i++) {
			game.roll(0);
		}
		int actual = game.score();
		Assertions.assertEquals(expected, actual);
	}
}
