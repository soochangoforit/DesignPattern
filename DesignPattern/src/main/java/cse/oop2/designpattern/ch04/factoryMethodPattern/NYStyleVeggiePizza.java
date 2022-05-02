package cse.oop2.designpattern.ch04.factoryMethodPattern;

public class NYStyleVeggiePizza extends Pizza{
    
    public NYStyleVeggiePizza(){
        name = "NY Style Sauce and Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        
        toppings.add("Grated Mushroom");
    }
    
}
