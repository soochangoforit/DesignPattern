package cse.oop2.designpattern.ch04.abstractFactoryPattern;

import cse.oop2.designpattern.ch04.abstractFactoryPattern.factory.NYPizzaIngredientFactory;




public class NYPizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String type) {
        
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        
        if(type.equals("cheese")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("ny cheese pizza");
           

        }else if(type.equals("claim")){
             pizza = new ClamPizza(ingredientFactory);
            pizza.setName("ny claim pizza");
        }else{
            return pizza;
        }
        
        return pizza;
    }
    
}
