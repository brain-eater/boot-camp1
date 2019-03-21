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
        assertEquals(new BigDecimal("304.8"), Unit.FEET.toMM(1));
    }
}