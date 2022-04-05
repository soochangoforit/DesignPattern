
package cse.oop2.designpattern.ch03.FinalDecoratorPattern;


public class StarbuzzCoffee {
    
    public static void main(String[] args) {


        
        Beverage b3 = new Espresso();
        System.out.println(b3.getDescription() + " & " + b3.cost());
        
        
        Beverage b2 = new Moca(new Moca(new Milk(new HouseBlend())));
        System.out.println(b2.getDescription() + " $ " + b2.cost());
        
        
    }
    
}
