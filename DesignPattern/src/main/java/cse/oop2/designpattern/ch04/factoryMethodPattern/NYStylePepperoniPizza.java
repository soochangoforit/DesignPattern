package cse.oop2.designpattern.ch04.factoryMethodPattern;

public class NYStylePepperoniPizza extends Pizza{
    
    public NYStylePepperoniPizza(){
        name = "NY Style Sauce and Pepperoni Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        
        toppings.add("add much more Pepperoni");
    }
    
}
