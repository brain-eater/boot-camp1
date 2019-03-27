package boot_camp.bag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Bag {
    private Map<Ball, Integer> ballsCount;
    private Map<Ball,Validator> ballValidators;
    private List<Validator> defaultValidators;

    Bag() {
        this.ballsCount = new HashMap<>();
        this.ballValidators = new HashMap<>();
        this.defaultValidators = new ArrayList<>();
    }

    boolean addBall(Ball ball) {
        Validator validator = this.ballValidators.get(ball);
        for (Validator defaultValidator : defaultValidators) {
            if (!defaultValidator.validate(this)){
                return false;
            }
        }
        if (validator.validate(this)) {
            Integer newCount = this.ballsCount.getOrDefault(ball, 0) + 1;
            this.ballsCount.put(ball, newCount);
            return true;
        }
        return false;
    }

    void addValidator(Ball ball, Validator validator){
        this.ballValidators.put(ball, validator);
    }

    void addValidator(Validator validator){
        this.defaultValidators.add(validator);
    }

    Integer getCountOf(Ball ball) {
        return ballsCount.getOrDefault(ball, 0);
    }

    Integer getTotalCount() {
        Integer totalCount = 0;
        for (Integer count : this.ballsCount.values()) {
            totalCount += count;
        }
        return totalCount;
    }
}
