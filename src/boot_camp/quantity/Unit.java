package boot_camp.quantity;

import java.math.BigDecimal;

public class Unit {

    public static final Unit FEET = new Unit(new BigDecimal("304.8"));
    public static final Unit INCH = new Unit(new BigDecimal("25.4"));
    public static final Unit CENTIMETER = new Unit(new BigDecimal("10.0"));
    public static final Unit MILLIMETER = new Unit(new BigDecimal("1.0"));

    private final BigDecimal ratioToMM;

    private Unit(BigDecimal ratioToMM) {
        this.ratioToMM = ratioToMM;
    }

    public BigDecimal toMM(int count) {
        return this.ratioToMM.multiply(new BigDecimal(count));
    }
}
