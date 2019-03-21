package boot_camp.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProbabilityTest {

    @Test
    void shouldNotThrowAnyException() {
        assertDoesNotThrow(() -> new Probability(1), "Exception");
    }

    @Test
    void shouldNotThrowAnyExceptionForValuesBetween0To1() {
        assertDoesNotThrow(() -> new Probability(0.5), "Exception");
    }

    @Test
    void shouldThrowInvalidInputExceptionIfValueIsGreaterThan1() {
        assertThrows(InvalidInputException.class, () -> new Probability(2));
    }

    @Test
    void shouldThrowInvalidInputExceptionIfValueIsLessThan0() {
        assertThrows(InvalidInputException.class, () -> new Probability(-2));
    }

    @Test
    void shouldReturnTheChanceOfNotGettingTail() throws Exception {
        Probability probability = new Probability(0.4);
        assertEquals(new Probability(0.6), probability.not());
    }

    @Test
    void shouldDoAndForGivenProbability() throws Exception {
        Probability probability = new Probability(0.5);
        Probability anotherProbability = probability.and(new Probability(0.5));
        assertEquals(new Probability(0.25), anotherProbability);
    }

    @Test
    void shouldDoOrForGivenProbability() throws Exception {
        Probability probability = new Probability(0.5);
        Probability anotherProbability = probability.or(new Probability(0.5));
        assertEquals(new Probability(0.75), anotherProbability);
    }
}