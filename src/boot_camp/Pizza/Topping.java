package boot_camp.Pizza;

public enum Topping {
    Vegetable(20, "Vegetable"),
    Chicken(30, "Chicken"),
    TOMATO_SAUCE(5, "Tomato sauce"),
    Mozzarella(10, "Mozzarella"),
    ExtraCheese(25, "Extra Cheese"),
    Jalapeno(40, "Jalapeno");


    private final int price;
    private final String name;

    Topping(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getCost() {
        return this.price;
    }

    public String getName() {
        return this.name;

    }
}
