package pizzastore;

import pizzastore.base.Pizza;
import pizzastore.store.NYPizzaStore;
import pizzastore.store.PizzaStore;
import pizzastore.toppings.ExtraCheese;
import pizzastore.toppings.Olives;

public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore store = new NYPizzaStore();

        Pizza pizza = store.orderPizza("cheese");
        pizza = new Olives(pizza);         // add olives
        pizza = new ExtraCheese(pizza);    // add extra cheese

        System.out.println("Total cost: $" + pizza.cost());
    }
}

