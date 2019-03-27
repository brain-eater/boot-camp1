package boot_camp.bag;

public class RedBallValidator implements Validator {
    @Override
    public boolean validate(Bag bag) {
        Integer greenBalls = bag.getCountOf(Ball.GREEN);
        Integer redBalls = bag.getCountOf(Ball.RED);
        return redBalls + 1 <= greenBalls * 2;
    }
}
