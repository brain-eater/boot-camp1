package boot_camp.shape;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {


    @Test
    void shouldReturnAreaOfTheRectangleWithIntegers() throws Exception {
        Shape rectangle = new Rectangle(new Dimension(1), new Dimension(2));
        assertEquals(2, rectangle.calculateArea());
    }

    @Test
    void shouldReturnAreaOfTheRectangleWithDouble() throws Exception {
        Shape rectangle = new Rectangle(new Dimension(1.5), new Dimension(2.5));
        assertEquals(3.75, rectangle.calculateArea(), 1);
    }

    @Test
    void shoultdCalculateParameterOfTheRectangle() throws Exception {
        Shape rectangle = new Rectangle(new Dimension(5), new Dimension(2));
        assertEquals(14, rectangle.calculateParameter());
    }

}