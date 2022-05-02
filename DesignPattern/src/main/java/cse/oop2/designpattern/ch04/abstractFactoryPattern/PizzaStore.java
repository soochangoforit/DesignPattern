package cse.oop2.designpattern.ch04.abstractFactoryPattern;

import cse.oop2.designpattern.ch04.factoryMethodPattern.*;


public abstract class PizzaStore {
    
    public Pizza orderPizza(String type){
        Pizza pizza;
        
        pizza = createPizza(type);
        
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        
        return pizza;
    }
    
    abstract Pizza createPizza(String type);
    
}
