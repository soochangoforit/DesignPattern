package cse.oop2.designpattern.ch04.factoryMethodPattern;


public class NYPizzaStore extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        if(type.equals("cheese")){
            return new NYStyleCheesePizza();
        }else if(type.equals("veggie")){
            return new NYStyleVeggiePizza();
        }else if(type.equals("claim")){
            return new NYStyleClamPizza();
        }else if(type.equals("pepporoni")){
            return new NYStylePepperoniPizza();
        }else{
            return null;
        }
    }
    
}
