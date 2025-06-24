package pizzastore.toppings;

import pizzastore.base.Pizza;

//Should be abstract so the subclasses decide the implementation
public abstract class ToppingDecorator extends Pizza {
    Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    //Provide Topping Cost in the Subclass
    public abstract double cost();
}
