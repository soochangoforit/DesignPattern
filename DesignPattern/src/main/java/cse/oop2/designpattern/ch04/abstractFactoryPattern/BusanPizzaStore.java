package cse.oop2.designpattern.ch04.abstractFactoryPattern;

import cse.oop2.designpattern.ch04.abstractFactoryPattern.factory.BusanPizzaIngredientFactory;
import cse.oop2.designpattern.ch04.abstractFactoryPattern.factory.NYPizzaIngredientFactory;




public class BusanPizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String type) {
        
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new BusanPizzaIngredientFactory();
        
        if(type.equals("cheese")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("busan cheese pizza");
           

        }else if(type.equals("claim")){
             pizza = new ClamPizza(ingredientFactory);
            pizza.setName("busan claim pizza");
        }else{
            return pizza;
        }
        
        return pizza;
    }
    
}
