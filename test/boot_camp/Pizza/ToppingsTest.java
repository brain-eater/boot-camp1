package boot_camp.Pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToppingsTest {
    @Test
    void shouldAddTopping() {
        Toppings toppings = new Toppings();
        toppings.add(Topping.TOMATO_SAUCE);
        assertEquals(5, toppings.getTotalCost());
    }

    @Test
    void shouldGiveTotalCostOfToppings() {
        Toppings toppings = new Toppings();
        toppings.add(Topping.TOMATO_SAUCE);
        toppings.add(Topping.TOMATO_SAUCE);
        toppings.add(Topping.Chicken);
        assertEquals(40, toppings.getTotalCost());
    }

    @Test
    void shouldGiveDescriptionForToppings() {
        Toppings toppings = new Toppings();
        toppings.add(Topping.TOMATO_SAUCE);
        toppings.add(Topping.Chicken);
        toppings.add(Topping.Vegetable);
        toppings.add(Topping.TOMATO_SAUCE);
        String expected = "Tomato sauce 5 , Chicken 30 , Vegetable 20 , Tomato sauce 5";
        assertEquals(expected, toppings.getDescription());
    }
}