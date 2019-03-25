package boot_camp.Pizza;

import java.util.ArrayList;

class Toppings {
    private ArrayList<Topping> toppings = new ArrayList<>();


    void add(Topping topping) {
        toppings.add(topping);
    }


    public int getTotalCost() {
        int cost = 0;
        for (Topping topping : toppings) {
            cost = cost + topping.getCost();
        }
        return cost;
    }

    public String getDescription() {
        String delimeter = "";
        StringBuilder description = new StringBuilder();
        for (Topping topping : toppings) {
            String toppingDescription = topping.getName() + " " + topping.getCost();
            description.append(delimeter);
            description.append(toppingDescription);
            delimeter = " , ";
        }
        return description.toString();
    }
}
