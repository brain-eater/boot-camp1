package boot_camp.bag;

public class MaxBallCountValidator implements Validator {
    private int maxBallCountAllowed;

    MaxBallCountValidator(int maxBallCountAllowed) {
        this.maxBallCountAllowed = maxBallCountAllowed;
    }

    @Override
    public boolean validate(Bag bag) {
        return bag.getTotalCount() <= this.maxBallCountAllowed;
    }
}
