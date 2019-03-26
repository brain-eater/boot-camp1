package boot_camp.bag;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldAddGreenBall() {
        Bag bag = new Bag();
        assertTrue(bag.addBall(Ball.GREEN));
    }

    @Test
    void shouldNotAddGreenBallIfAlreadyThreeGreenArePresent() {
        Bag bag = new Bag();
        bag.addBall(Ball.GREEN);
        bag.addBall(Ball.GREEN);
        bag.addBall(Ball.GREEN);
        assertFalse(bag.addBall(Ball.GREEN));
    }

    @Test
    void shouldAddRedBall() {
        Bag bag = new Bag();
        bag.addBall(Ball.GREEN);
        assertTrue(bag.addBall(Ball.RED));
    }

    @Test
    void shouldNotAddRedBallIfRedBallsDoubleOfGreenBallsAreAlreadyPresent() {
        Bag bag = new Bag();
        bag.addBall(Ball.GREEN);
        bag.addBall(Ball.RED);
        bag.addBall(Ball.RED);
        assertFalse(bag.addBall(Ball.RED));
    }
}