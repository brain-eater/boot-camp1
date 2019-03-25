package boot_camp.quantity;

import java.math.BigDecimal;

public class RatioConvertedUnit extends Unit {

    static final RatioConvertedUnit GALLON = new RatioConvertedUnit(new BigDecimal("3.78541"), UnitType.VOLUME);

    static final RatioConvertedUnit LITER = new RatioConvertedUnit(new BigDecimal("1"), UnitType.VOLUME);


    static final RatioConvertedUnit INCH = new RatioConvertedUnit(new BigDecimal("25.0"), UnitType.LENGTH);
    static final RatioConvertedUnit FEET = new RatioConvertedUnit(new BigDecimal("300.0"), UnitType.LENGTH);
    static final RatioConvertedUnit CENTIMETER = new RatioConvertedUnit(new BigDecimal("10.0"), UnitType.LENGTH);
    static final RatioConvertedUnit MILLIMETER = new RatioConvertedUnit(new BigDecimal("1.0"), UnitType.LENGTH);

    RatioConvertedUnit(BigDecimal ratio, UnitType type) {
        super(ratio, type);
    }

    @Override
    BigDecimal toBaseValue(BigDecimal value) {
        return null;
    }

    @Override
    BigDecimal convertTo(Unit unit, BigDecimal value) {
        return null;
    }

}
