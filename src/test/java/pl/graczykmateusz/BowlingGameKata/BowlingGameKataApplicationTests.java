package pl.graczykmateusz.BowlingGameKata;

import org.assertj.core.api.Assertions;
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
	void should_throw_exception_when_pins_are_smaller_then_zero() {
		final String expectedDescription = "Pins cannot be smaller then 0";
		final int pins = -1;
		Assertions.assertThatIllegalArgumentException()
				.describedAs(expectedDescription)
				.isThrownBy(() -> game.roll(pins));
	}

	@Test
	void should_throw_exception_when_pins_are_greater_than_ten() {
		final String expectedDescription = "Pins cannot be greater then 10";
		final int pins = 11;
		Assertions.assertThatIllegalArgumentException()
				.describedAs(expectedDescription)
				.isThrownBy(() -> game.roll(pins));
	}

	@Test
	void should_throw_exception_when_is_another_roll_after_game_over() {
		final String expectedDescription = "Cannot roll when the game is over!";
		final int rollsCount = 12;
		final int pins = 10;

		for (int i = 0; i < rollsCount; i++) {
			game.roll(pins);
		}

		Assertions.assertThatIllegalStateException()
				.describedAs(expectedDescription)
				.isThrownBy(() -> game.roll(pins));
	}

	@Test
	void should_score_equals_0_when_miss_all_rolls() {
		final int rollsCount = 20;
		final int expected = 0;
		final int pins = 0;

		for (int i = 0; i < rollsCount ; i++) {
			game.roll(pins);
		}
		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void should_score_equals_150_when_always_roll_5_per_roll() {
		final int rollsCount = 21;
		final int expected = 150;
		final int pins = 5;

		for (int i = 0; i < rollsCount ; i++) {
			game.roll(pins);
		}
		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void should_score_equals_pins_sum_when_no_rolled_any_strike_or_spare_per_roll() {
		final int rollsCount = 20;
		final int expected = 40;
		final int pins = 2;

		for (int i = 0; i < rollsCount; i++) {
			game.roll(pins);
		}
		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void shouldScoreEqualsThreeHundredWhenRolledTenPinsPerRoll() {
		final int rollsCount = 12;
		final int expected = 300;
		final int pins = 10;

		for (int i = 0; i < rollsCount; i++) {
			game.roll(pins);
		}
		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void shouldScoreEqualsSumWhenRolledAllCapabilities() {
		final int expected = 191;

		//Round 1
		game.roll(8);
		game.roll(1);

		//Round 2
		game.roll(5);
		game.roll(5);

		//Round 3
		game.roll(9);
		game.roll(0);

		//Round 4
		game.roll(7);
		game.roll(3);

		//Round 5
		game.roll(10);

		//Round 6
		game.roll(10);

		//Round 7
		game.roll(10);

		//Round 8
		game.roll(7);
		game.roll(3);

		//Round 9
		game.roll(9);
		game.roll(0);

		//Round 10
		game.roll(10);
		game.roll(10);
		game.roll(9);

		Assertions.assertThat(game.score()).isEqualTo(expected);
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

		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void example2() {
		final int expected = 160;

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
		game.roll(5);
		game.roll(5);

		//Round 10
		game.roll(10);
		game.roll(10);
		game.roll(10);

		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void example3() {
		final int expected = 148;

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
		game.roll(5);
		game.roll(3);

		//Round 10
		game.roll(10);
		game.roll(10);
		game.roll(10);

		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void example4() {
		final int expected = 138;

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
		game.roll(5);
		game.roll(3);

		//Round 10
		game.roll(5);
		game.roll(5);
		game.roll(10);

		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void example5() {
		final int expected = 145;

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
		game.roll(5);
		game.roll(5);

		//Round 10
		game.roll(5);
		game.roll(5);
		game.roll(10);

		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void example6() {
		final int expected = 129;

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
		game.roll(5);
		game.roll(5);

		//Round 10
		game.roll(3);
		game.roll(3);

		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void example7() {
		final int expected = 132;

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
		game.roll(10);

		//Round 10
		game.roll(3);
		game.roll(3);

		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void example8() {
		final int expected = 143;

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
		game.roll(10);

		//Round 10
		game.roll(5);
		game.roll(5);
		game.roll(3);

		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void example9() {
		final int expected = 150;

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
		game.roll(10);

		//Round 10
		game.roll(5);
		game.roll(5);
		game.roll(10);

		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void example11() {
		final int expected = 190;

		//Round 1
		game.roll(5);
		game.roll(5);

		//Round 2
		game.roll(10);

		//Round 3
		game.roll(5);
		game.roll(5);

		//Round 4
		game.roll(10);

		//Round 5
		game.roll(5);
		game.roll(5);

		//Round 6
		game.roll(10);

		//Round 7
		game.roll(5);
		game.roll(5);

		//Round 8
		game.roll(10);

		//Round 9
		game.roll(5);
		game.roll(5);

		//Round 10
		game.roll(0);
		game.roll(10);
		game.roll(10);

		Assertions.assertThat(game.score()).isEqualTo(expected);
	}

	@Test
	void example12() {
		final int expected = 290;

		//Round 1
		game.roll(0);
		game.roll(10);

		//Round 2
		game.roll(10);

		//Round 3
		game.roll(10);

		//Round 4
		game.roll(10);

		//Round 5
		game.roll(10);

		//Round 6
		game.roll(10);

		//Round 7
		game.roll(10);

		//Round 8
		game.roll(10);

		//Round 9
		game.roll(10);

		//Round 10
		game.roll(10);
		game.roll(10);
		game.roll(10);

		Assertions.assertThat(game.score()).isEqualTo(expected);
	}
}
