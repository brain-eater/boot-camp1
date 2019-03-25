package boot_camp.quantity;

import java.math.BigDecimal;
import java.util.HashMap;

abstract class Unit {

    static final Unit FAHRENHEIT = new Unit(new BigDecimal("1.0"), new BigDecimal("0"), UnitType.TEMPERATURE);
    static final Unit CELSIUS = new Unit(new BigDecimal("1.8"), new BigDecimal("32"), UnitType.TEMPERATURE);

    private final BigDecimal ratio;
    private final UnitType type;
    private static final HashMap<UnitType, Unit> standardUnits;

    static {
        standardUnits = new HashMap<>();
        standardUnits.put(UnitType.LENGTH, RatioConvertedUnit.INCH);
        standardUnits.put(UnitType.VOLUME, RatioConvertedUnit.LITER);
        standardUnits.put(UnitType.TEMPERATURE, FAHRENHEIT);
    }

    Unit(BigDecimal ratio, UnitType type) {
        this.ratio = ratio;
        this.type = type;
    }

    Boolean isSameType(Unit unit) {
        return this.type == unit.type;
    }

    abstract BigDecimal toBaseValue(BigDecimal value);
//    {
//        return value.multiply(this.ratio).add(this.scale);
//    }

    abstract BigDecimal convertTo(Unit unit, BigDecimal value);
//    {
//        return this.ratio.divide(unit.ratio, 2, RoundingMode.HALF_EVEN).multiply(value).add(this.scale);
//    }

    Unit getStandardUnit() {
        return standardUnits.get(this.type);
    }
}
