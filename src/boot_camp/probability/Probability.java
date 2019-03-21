package boot_camp.probability;

import java.util.Objects;

class Probability {

    private final static int LOWER_BOUND = 0;
    private final static int UPPER_BOUND = 1;
    private double value;

    Probability(double value) throws Exception {
        validate(value);
        this.value = value;
    }

    private static void validate(double value) throws Exception {
        if (value < LOWER_BOUND || value > UPPER_BOUND) throw new InvalidInputException();
    }

    Probability not() throws Exception {
        return new Probability(UPPER_BOUND - value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    Probability and(Probability newProb) throws Exception {
        return new Probability(this.value * newProb.value);
    }

    Probability or(Probability probability) throws Exception {
        double orProbabilityVal = this.value + probability.value - this.and(probability).value;
        return new Probability(orProbabilityVal);
    }
}
