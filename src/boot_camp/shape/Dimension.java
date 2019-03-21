package boot_camp.shape;

class Dimension {
    private double value;

    Dimension(double value) throws InvalidInputException {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(double value) throws InvalidInputException {
        if (value < 0) {
            throw new InvalidInputException();
        }

    }

    double getValue() {
        return value;
    }
}
