package cse.oop2.designpattern.ch03.AdvDecoratorPattern;



public class HouseBlend extends Beverage{
    
    public HouseBlend(){
        description = "House Blend Coffee";
    }
    
    public double cost(){
        return 0.89 + super.cost();
    }
    
}
