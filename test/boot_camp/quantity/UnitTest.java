package boot_camp.quantity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    void shouldGiveInstanceOfUnit() {
        assertDoesNotThrow(() -> {
            Unit feet = Unit.FEET;
        });
    }

    @Test
    void shouldConvertToMM() {
        assertEquals(new BigDecimal("300.0"), Unit.FEET.toBaseValue(new BigDecimal("1")));
    }

    @Test
    void shouldConvertFahrenheitToCelsius() {
        BigDecimal actual = Unit.CELSIUS.convertTo(Unit.FAHRENHEIT, new BigDecimal("1"));
        BigDecimal expected = new BigDecimal("33.80");

        assertEquals(expected, actual);
    }
}