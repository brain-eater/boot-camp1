package boot_camp.shape;

public class Square implements Shape {
    private Dimension side;

    public Square(Dimension side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return Math.pow(this.side.getValue(), 2);
    }

    @Override
    public double calculateParameter() {
        return 4 * this.side.getValue();
    }
}
