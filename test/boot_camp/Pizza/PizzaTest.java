package boot_camp.Pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaTest {
    @Test
    void shouldAddToppingToThePizza() {
        Pizza pizza = new Pizza(new Toppings());
        pizza.add(Topping.TOMATO_SAUCE);
        assertEquals(55, pizza.getCost());
    }

    @Test
    void shouldGiveDescription() {
        Pizza pizza = new Pizza(new Toppings());
        pizza.add(Topping.TOMATO_SAUCE);
        pizza.add(Topping.Chicken);
        String description = "Plain Pizza = 50\nToppings => Tomato sauce 5 , Chicken 30";
        assertEquals(description, pizza.getDescription());
    }
}