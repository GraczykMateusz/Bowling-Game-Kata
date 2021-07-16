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
	void shouldThrowExceptionWhenPinsAreUnderZero() {

	}

	@Test
	void shouldThrowExceptionWhenPinsAreGreaterThanTen() {

	}

	@Test
	void shouldThrowExceptionWhenIsAnotherRollAfterGameOver() {

	}

	@Test
	void shouldScoreEqualsZeroWhenMissAllRolls() {
		final int rollsCount = 20;
		final int expected = 0;
		final int pins = 0;

		for (int i = 0; i < rollsCount ; i++) {
			game.roll(pins);
		}
		int actual = game.score();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void shouldScoreEqualsSumOfPinsWhenNoRolledAnyStrikeOrSparePerRoll() {
		final int rollsCount = 20;
		final int expected = 40;
		final int pins = 2;

		for (int i = 0; i < rollsCount; i++) {
			game.roll(pins);
		}
		int actual = game.score();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void shouldScoreEqualsThreeHundredWhenRolledTenPinsPerRoll() {
		final int rollsCount = 12;
		final int expected = 300;
		final int pins = 10;

		for (int i = 0; i < rollsCount; i++) {
			game.roll(pins);
		}
		int actual = game.score();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void shouldScoreEqualsSumWhenRolledAllCapabilities() {
		final int expected = 191;

		//Round 1
		game.roll(8);
		game.roll(1);
		Assertions.assertEquals(9, game.score());

		//Round 2
		game.roll(5);
		game.roll(5);

		//Round 3
		game.roll(9);
		Assertions.assertEquals(28, game.score());
		game.roll(0);
		Assertions.assertEquals(37, game.score());

		//Round 4
		game.roll(7);
		game.roll(3);

		//Round 5
		game.roll(10);
		Assertions.assertEquals(57, game.score());

		//Round 6
		game.roll(10);

		//Round 7
		game.roll(10);
		Assertions.assertEquals(87, game.score());

		//Round 8
		game.roll(7);
		Assertions.assertEquals(114, game.score());
		game.roll(3);
		Assertions.assertEquals(134, game.score());

		//Round 9
		game.roll(9);
		Assertions.assertEquals(153, game.score());
		game.roll(0);
		Assertions.assertEquals(162, game.score());

		//Round 10
		game.roll(10);
		game.roll(10);
		game.roll(9);

		int actual = game.score();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void example() {
		final int expected = 149;

		//Round 1
		game.roll(8);
		game.roll(2);

		//Round 2
		game.roll(5);
		game.roll(4);

		//Round 3
		game.roll(9);
		game.roll(0);

		//Round 4
		game.roll(10);

		//Round 5
		game.roll(10);

		//Round 6
		game.roll(5);
		game.roll(5);

		//Round 7
		game.roll(5);
		game.roll(3);

		//Round 8
		game.roll(6);
		game.roll(3);

		//Round 9
		game.roll(9);
		game.roll(1);

		//Round 10
		game.roll(9);
		game.roll(1);
		game.roll(10);

		int actual = game.score();
		Assertions.assertEquals(expected, actual);
	}
}
