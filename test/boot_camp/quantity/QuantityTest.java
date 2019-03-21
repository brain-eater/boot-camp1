package boot_camp.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @Test
    void shouldReturnTrueIfQuantitiesAreEqual() {
        Quantity quantity1 = new Quantity(12, Unit.FEET);
        Quantity quantity2 = new Quantity(12, Unit.FEET);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void shouldReturnTrueForOneFeetAndTwelveInch() {
        Quantity oneFeet = new Quantity(1, Unit.FEET);
        Quantity twelveInch = new Quantity(12, Unit.INCH);
        assertEquals(oneFeet, twelveInch);
    }

    @Test
    void shouldReturnTrueFor2InchesAnd5Cm() {
        Quantity twoInches = new Quantity(2, Unit.INCH);
        Quantity fiveCM = new Quantity(5, Unit.CENTIMETER);
        assertEquals(twoInches, fiveCM);
    }

    @Test
    void shouldReturnTrueFor2CMAnd20MM() {
        Quantity twoCM = new Quantity(2, Unit.CENTIMETER);
        Quantity twentyMM = new Quantity(20, Unit.MILLIMETER);
        assertEquals(twoCM, twentyMM);
    }
}


