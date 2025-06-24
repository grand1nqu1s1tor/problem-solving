package pizzastore.toppings;

import pizzastore.base.Pizza;

public class ExtraCheese extends ToppingDecorator {

    public ExtraCheese(Pizza pizza) {
        super(pizza);
    }

    public double cost() {
        return pizza.cost() + 2.0;
    }
}
