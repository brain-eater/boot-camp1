package boot_camp.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DimensionTest {

    @Test
    void shouldGiveExceptionWhenTheInputIsNegative() {
        assertThrows(InvalidInputException.class, () -> new Dimension(-1));
    }

    @Test
    void shouldCreateADimensionInstanceForValidInput() throws InvalidInputException {
        assertEquals(1, new Dimension(1).getValue());
    }

}