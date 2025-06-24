package pizzastore.store;

import pizzastore.base.CheesePizza;
import pizzastore.base.Pizza;
import pizzastore.base.VegPizza;

// These sub-classes(pizza stores) can define their own way of creating pizza BEHAVIOR
public class NYPizzaStore extends PizzaStore {
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) return new CheesePizza();
        if (type.equals("veg")) return new VegPizza();
        return null;
    }
}
