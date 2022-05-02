
package cse.oop2.designpattern.ch04.abstractFactoryPattern;

public class Teste {

    public static void main(String[] args) {
       Pizza pizza = null;
       PizzaStore nyPizzaStore = new NYPizzaStore();
       PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
       PizzaStore busanPizzaStore = new BusanPizzaStore();
       
       pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("-----------------");
       pizza = chicagoPizzaStore.orderPizza("claim");
       System.out.println("-----------------");
       pizza = busanPizzaStore.orderPizza("cheese");
    }
    
}
