package boot_camp.bag;

import java.util.HashMap;
import java.util.Map;

class Bag {
    private Map<Ball, Integer> ballsCount;
    private Map<Ball, Validator> ballValidators;


    Bag() {
        this.ballsCount = new HashMap<>();
        this.ballsCount.put(Ball.RED, 0);
        this.ballsCount.put(Ball.BLUE, 0);
        this.ballsCount.put(Ball.GREEN, 0);
        this.ballsCount.put(Ball.YELLOW, 0);

        this.ballValidators = new HashMap<>();
        this.ballValidators.put(Ball.RED, redBallValidator);
        this.ballValidators.put(Ball.GREEN, greenBallValidator);
    }

    boolean addBall(Ball ball) {
        Validator validator = this.ballValidators.get(ball);
        if (validator.validate()) {
            Integer newCount = this.ballsCount.get(ball) + 1;
            this.ballsCount.put(ball, newCount);
            return true;
        }
        return false;
    }

    private Validator redBallValidator = () -> {
        Integer greenBalls = this.ballsCount.get(Ball.GREEN);
        Integer redBalls = this.ballsCount.get(Ball.RED);
        return redBalls + 1 <= greenBalls * 2;
    };


    private Validator greenBallValidator = () -> {
        Integer greenBalls = this.ballsCount.get(Ball.GREEN);
        return greenBalls < 3;
    };

    private interface Validator {
        boolean validate();
    }
}
