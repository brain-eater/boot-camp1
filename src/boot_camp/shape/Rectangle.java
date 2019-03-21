package boot_camp.shape;

public class Rectangle implements Shape {

    private Dimension length;
    private Dimension breadth;

    Rectangle(Dimension length, Dimension breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        return this.length.getValue() * this.breadth.getValue();
    }

    @Override
    public double calculateParameter() {
        return 2 * (this.length.getValue() + this.breadth.getValue());
    }


}
