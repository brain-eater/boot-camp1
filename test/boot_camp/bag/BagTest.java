package boot_camp.bag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldAddGreenBall() {
        Bag bag = new Bag();
        bag.addValidator(Ball.GREEN, new GreenBallValidator());
        assertTrue(bag.addBall(Ball.GREEN));
    }

    @Test
    void shouldNotAddGreenBallIfAlreadyThreeGreenArePresent() {
        Bag bag = new Bag();
        bag.addValidator(Ball.GREEN, new GreenBallValidator());
        bag.addBall(Ball.GREEN);
        bag.addBall(Ball.GREEN);
        bag.addBall(Ball.GREEN);
        assertFalse(bag.addBall(Ball.GREEN));
    }

    @Test
    void shouldAddRedBall() {
        Bag bag = new Bag();
        bag.addValidator(Ball.GREEN, new GreenBallValidator());
        bag.addValidator(Ball.RED, new RedBallValidator());
        bag.addBall(Ball.GREEN);
        assertTrue(bag.addBall(Ball.RED));
    }

    @Test
    void shouldNotAddRedBallIfRedBallsDoubleOfGreenBallsAreAlreadyPresent() {
        Bag bag = new Bag();
        bag.addValidator(Ball.GREEN, new GreenBallValidator());
        bag.addValidator(Ball.RED, new RedBallValidator());
        bag.addBall(Ball.GREEN);
        bag.addBall(Ball.RED);
        bag.addBall(Ball.RED);
        assertFalse(bag.addBall(Ball.RED));
    }

    @Test
    void shouldNotAddABallIfBagIsFull() {
        Bag bag = new Bag();
        bag.addValidator(Ball.GREEN, new GreenBallValidator());
        bag.addValidator(new MaxBallCountValidator(1));
        assertTrue(bag.addBall(Ball.GREEN));
    }
}