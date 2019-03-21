package boot_camp.quantity;

import java.util.Objects;

class Quantity {
    private final int VAlUE;
    private final Unit unit;

    Quantity(int VAlUE, Unit unit) {
        this.VAlUE = VAlUE;
        this.unit = unit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        int thisMM = this.unit.toMM(this.VAlUE).intValue();
        Quantity quantity = (Quantity) o;
        int thatMM = quantity.unit.toMM(quantity.VAlUE).intValue();
        return thisMM == thatMM;

    }

    @Override
    public int hashCode() {
        return Objects.hash(VAlUE, unit);
    }
}
