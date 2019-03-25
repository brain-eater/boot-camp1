package boot_camp.Pizza;

public class Pizza {

    private static final int BASE_PRICE = 50;
    private Toppings toppings;

    public Pizza(Toppings toppings) {
        this.toppings = toppings;
    }

    public void add(Topping topping) {
        toppings.add(topping);
    }

    public int getCost() {
        return BASE_PRICE + toppings.getTotalCost();
    }

    public String getDescription() {
        String toppingDescription = toppings.getDescription();
        String pizzaDescription = "Plain Pizza = " + BASE_PRICE;
        return pizzaDescription + "\n" + "Toppings => " + toppingDescription;
    }
}
