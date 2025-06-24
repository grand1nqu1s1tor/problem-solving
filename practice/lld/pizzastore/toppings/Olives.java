package pizzastore.toppings;

import pizzastore.base.Pizza;

public class Olives extends ToppingDecorator {

    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double cost() {
        return pizza.cost() + 1.0;
    }
}
