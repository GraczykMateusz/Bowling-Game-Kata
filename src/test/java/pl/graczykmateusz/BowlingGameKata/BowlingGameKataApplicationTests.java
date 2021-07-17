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
	void should_ignore_too_much_rolls() {
		final int rollsCount = 15;
		final int expected = 300;
		final int pins = 10;

		for (int i = 0; i < rollsCount; i++) {
			game.roll(pins);
		}

		Assertions.assertThat(game.score()).isEqualTo(expected);
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
	void should_score_equals_300_when_roll_always_strike() {
		final int rollsCount = 12;
		final int expected = 300;
		final int pins = 10;

		for (int i = 0; i < rollsCount; i++) {
			game.roll(pins);
		}
		Assertions.assertThat(game.score()).isEqualTo(expected);
	}
}
