package boot_camp.bag;

public class GreenBallValidator implements Validator {
    @Override
    public boolean validate(Bag bag) {
        Integer greenBalls = bag.getCountOf(Ball.GREEN);
        return greenBalls < 3;
    }
}
