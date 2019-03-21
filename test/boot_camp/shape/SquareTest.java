package boot_camp.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void calculateAreaWithNaturalNumber() throws InvalidInputException {
        Square square = new Square(new Dimension(2));
        assertEquals(4, square.calculateArea());
    }

    @Test
    void calculateAreaWithFloatingValue() throws InvalidInputException {
        Square square = new Square(new Dimension(2.2));
        assertEquals(4.84, square.calculateArea(), 0.01);
    }

    @Test
    void calculateParameter() throws InvalidInputException {
        Square square = new Square(new Dimension(2));
        assertEquals(8, square.calculateParameter());
    }

    @Test
    void calculateParameterWithFloatingValue() throws InvalidInputException {
        Square square = new Square(new Dimension(2.2));
        assertEquals(8.8, square.calculateParameter());
    }
}