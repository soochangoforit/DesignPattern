package cse.oop2.designpattern.ch03.DecoratorPattern;

public class HouseBlend extends Beverage{
    
    public HouseBlend(){
        desciption = "House Blend Coffee";
    }
    
    public double cost(){
        return 0.89;
    }
    
}
