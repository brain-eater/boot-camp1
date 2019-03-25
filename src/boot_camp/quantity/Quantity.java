package boot_camp.quantity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

class Quantity {
    private final BigDecimal value;
    private final Unit unit;

    Quantity(BigDecimal value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        if (!quantity.unit.isSameType(this.unit)) return false;
        BigDecimal thisBaseValue = this.unit.toBaseValue(this.value);
        BigDecimal thatBaseValue = quantity.unit.toBaseValue(quantity.value);
        return round(thisBaseValue).equals(round(thatBaseValue));

    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    Quantity add(Quantity quantity) throws IncompatibleQuantityTypeException {
        if (!this.unit.isSameType(quantity.unit)) throw new IncompatibleQuantityTypeException();
        BigDecimal thisInchValue = this.unit.convertTo(this.unit.getStandardUnit(), this.value);
        BigDecimal otherQuantityInchValue = quantity.unit.convertTo(this.unit.getStandardUnit(), quantity.value);
        BigDecimal newQuantityValue = thisInchValue.add(otherQuantityInchValue);
        return new Quantity(round(newQuantityValue), this.unit.getStandardUnit());
    }

    private BigDecimal round(BigDecimal bigDecimal){
        return bigDecimal.setScale(0, RoundingMode.HALF_UP);
    }
}
