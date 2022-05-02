package cse.oop2.designpattern.ch04.factoryMethodPattern;

public class ChicagoStyleCheesePizza extends Pizza{
    
    public ChicagoStyleCheesePizza(){
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        
        toppings.add("Shredded Mozzarella Cheese");
    }
    
    
    void cut(){
        System.out.println("Cutting the pizza tinto square slices");
    }
    
}
