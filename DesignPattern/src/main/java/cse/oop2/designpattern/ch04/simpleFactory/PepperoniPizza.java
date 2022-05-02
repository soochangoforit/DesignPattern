
package cse.oop2.designpattern.ch04.simpleFactory;

public class PepperoniPizza extends Pizza{
    
    public PepperoniPizza(){
        name = "Pepperoni Pizza";
        dough = "Crust";
        sauce = "Marinara Pizza Sauce";
        toppings.add("Onion");
        toppings.add("more Pepperoni");
    }
    
}
