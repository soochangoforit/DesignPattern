package cse.oop2.designpattern.ch04.factoryMethodPattern;

public class ChicagoStyleVeggiePizza extends Pizza{
    
    public ChicagoStyleVeggiePizza(){
        name = "chicago style Sauce and Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        
        toppings.add("Grated Mushroom");
    }
    
}
