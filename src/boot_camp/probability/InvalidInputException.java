package boot_camp.probability;

public class InvalidInputException extends Exception {
    public InvalidInputException() {
        super("Probability has to be between 0 and 1");
    }
}
