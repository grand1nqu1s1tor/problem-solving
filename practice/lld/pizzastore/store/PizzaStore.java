package pizzastore.store;

import pizzastore.base.Pizza;

// Factory Class which encapsulates the Decision Logic
// createPizza() method will decide what to instantiate
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        //We should not do this
        //We want the OrderPizza behavior to stay consistent across all stores
        //Pizza pizza = new CheesePizza();
        Pizza pizza = createPizza(type);
        return pizza;
    }

    //Logic delegated to this method which lets Subclasses decide what to instantiate
    protected abstract Pizza createPizza(String type);
}/*
 We’re using inheritance to model different pizza types,
 and the Factory Method Pattern to encapsulate the decision
 of which type to create.
 This way, new pizza types can be added without modifying
  the existing store logic — we just override createPizza()
  in a new subclass of PizzaStore.*/