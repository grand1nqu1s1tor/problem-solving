package pizzastore.base;

// BASIC inheritance
// Concrete class extending Base Class
// Foundational Polymorphism OOP since we can create different pizzas
public class CheesePizza extends Pizza{
    public CheesePizza() {
    }

    //Overridden method
    public double cost() {
        return 8.0;
    }
}

