
package cse.oop2.designpattern.ch04.simpleFactory;


public class VeggiePizza extends Pizza {
    
    public VeggiePizza(){
        name = "Veggie Pizza";
        dough = "Crust";
        sauce = "Marinara sauce";
        toppings.add("Shredded mozzarealla");
        toppings.add("more cheese");
    }
    
}
