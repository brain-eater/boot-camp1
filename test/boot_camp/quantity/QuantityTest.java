package boot_camp.quantity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @Test
    void shouldReturnTrueIfQuantitiesAreEqual() {
        Quantity quantity1 = new Quantity(new BigDecimal("12"), RatioConvertedUnit.FEET);
        Quantity quantity2 = new Quantity(new BigDecimal("12"), RatioConvertedUnit.FEET);
        assertEquals(quantity1, quantity2);
    }

    @Test
    void shouldReturnTrueForOneFeetAndTwelveInch() {
        Quantity oneFeet = new Quantity(new BigDecimal("1"), RatioConvertedUnit.FEET);
    Quantity twelveInch = new Quantity(new BigDecimal("12"), RatioConvertedUnit.INCH);
        assertEquals(oneFeet, twelveInch);
    }

    @Test
    void shouldReturnTrueFor2InchesAnd5Cm() {
        Quantity twoInches = new Quantity(new BigDecimal("2.0"), RatioConvertedUnit.INCH);
        Quantity fiveCM = new Quantity(new BigDecimal("5.0"), RatioConvertedUnit.CENTIMETER);
        assertEquals(twoInches, fiveCM);
    }

    @Test
    void shouldReturnTrueFor2CMAnd20MM() {
        Quantity twoCM = new Quantity(new BigDecimal("2"), RatioConvertedUnit.CENTIMETER);
        Quantity twentyMM = new Quantity(new BigDecimal("20"), RatioConvertedUnit.MILLIMETER);
        assertEquals(twoCM, twentyMM);
    }

    @Test
    void shouldReturnTrueFor1GallonEquivalentToLiters() {
        Quantity oneGallon = new Quantity(new BigDecimal("1"), RatioConvertedUnit.GALLON);
        Quantity someLiters = new Quantity(new BigDecimal("3.78"), RatioConvertedUnit.LITER);
        assertEquals(oneGallon, someLiters);
    }

    @Test
    void shouldReturnFalseForForTwoDifferentUnits() {
        Quantity oneGallon = new Quantity(new BigDecimal("1"), RatioConvertedUnit.MILLIMETER);
        Quantity someLiters = new Quantity(new BigDecimal("3.78"), RatioConvertedUnit.LITER);
        assertNotEquals(oneGallon, someLiters);
    }

    @Test
    void shouldReturn4InchesWhen2Inchesand2InchesAreAdded() throws IncompatibleQuantityTypeException {
        Quantity twoInches = new Quantity(new BigDecimal("2"), RatioConvertedUnit.INCH);
        Quantity anotherTwoInches = new Quantity(new BigDecimal("2"), RatioConvertedUnit.INCH);
        Quantity expected = new Quantity(new BigDecimal("4"), RatioConvertedUnit.INCH);
        Quantity actual = twoInches.add(anotherTwoInches);
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionWhenAddingTwoDifferentTypeOfQuantities() {
        Quantity twoInches = new Quantity(new BigDecimal("2"), RatioConvertedUnit.INCH);
        Quantity twoLiters = new Quantity(new BigDecimal("2"), RatioConvertedUnit.LITER);
        assertThrows(IncompatibleQuantityTypeException.class, () -> twoInches.add(twoLiters));
    }

    @Test
    void shouldAddInchAndCM() throws IncompatibleQuantityTypeException {
        Quantity twoInches = new Quantity(new BigDecimal("2"), RatioConvertedUnit.INCH);
        Quantity twoHalfCM = new Quantity(new BigDecimal("2.5"), RatioConvertedUnit.CENTIMETER);
        Quantity actual = twoInches.add(twoHalfCM);
        Quantity expected = new Quantity(new BigDecimal("3"), RatioConvertedUnit.INCH);
        assertEquals(expected, actual);

    }


    @Test
    void shouldAddFeetAndCM() throws IncompatibleQuantityTypeException {
        Quantity oneFeet = new Quantity(new BigDecimal("1"), RatioConvertedUnit.FEET);
        Quantity twoHalfCM = new Quantity(new BigDecimal("2.5"), RatioConvertedUnit.CENTIMETER);
        Quantity actual = oneFeet.add(twoHalfCM);
        Quantity expected = new Quantity(new BigDecimal("13"), RatioConvertedUnit.INCH);
        assertEquals(expected, actual);
    }


    @Test
    void shouldAddOneLitreAndOneGallon() throws IncompatibleQuantityTypeException {
        Quantity oneLitre = new Quantity(new BigDecimal("1"), RatioConvertedUnit.LITER);
        Quantity oneGallon = new Quantity(new BigDecimal("1"), RatioConvertedUnit.GALLON);
        Quantity actual = oneLitre.add(oneGallon);
        Quantity expected = new Quantity(new BigDecimal("4.78"), RatioConvertedUnit.LITER);
        assertEquals(expected, actual);
    }

    @Test
    void shouldAssertThat212FahrenheitIsEqualTo100Celsius() {
        Quantity twoHundredAndTwelveDegreeFahrenheits = new Quantity(new BigDecimal("212"), Unit.FAHRENHEIT);
        Quantity hundredDegreeCelsius = new Quantity(new BigDecimal("100"), Unit.CELSIUS);
        assertEquals(twoHundredAndTwelveDegreeFahrenheits, hundredDegreeCelsius);
    }
}


