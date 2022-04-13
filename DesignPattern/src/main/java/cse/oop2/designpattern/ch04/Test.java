
package cse.oop2.designpattern.ch04;


public class Test {
    
    public static void main(String[] args) {
        
         SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore store = new PizzaStore(factory);
    
        Pizza pizza = store.orderPizza("cheese");
        System.out.println("ordered " + pizza.name + "\n");
        
        pizza = store.orderPizza("veggie");
        System.out.println("ordered " + pizza.name + "\n");
        
    
        
    }
    
}
