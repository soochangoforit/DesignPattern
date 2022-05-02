package cse.oop2.designpattern.ch04.factoryMethodPattern;

public class ChicagoPizzaStore extends PizzaStore{

    @Override
    Pizza createPizza(String type) {
        if(type.equals("cheese")){
                   return new ChicagoStyleCheesePizza();
               }else if(type.equals("veggie")){
                   return new ChicagoStyleVeggiePizza();
               }else if(type.equals("claim")){
                   return new ChicagoStyleClamPizza();
               }else if(type.equals("pepporoni")){
                   return new ChicagoStylePepperoniPizza();
               }else{
                   return null;
               }
    }
    
}
