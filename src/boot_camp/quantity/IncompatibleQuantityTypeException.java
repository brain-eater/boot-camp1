package boot_camp.quantity;

public class IncompatibleQuantityTypeException extends Exception{
    public IncompatibleQuantityTypeException() {
        super("Both quantities should be of same type");
    }
}
