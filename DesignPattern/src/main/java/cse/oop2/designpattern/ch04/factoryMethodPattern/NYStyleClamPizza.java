package cse.oop2.designpattern.ch04.factoryMethodPattern;

public class NYStyleClamPizza extends Pizza{
    
    public NYStyleClamPizza(){
        name = "NY Style Sauce and Claim Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        
        toppings.add("Grated shell and more Claims");
    }
    
}
