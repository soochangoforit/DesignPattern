package cse.oop2.designpattern.ch03.DecoratorPattern;


public class HouseBlendWithSteamedMilk extends Beverage{
    
    public HouseBlendWithSteamedMilk(){
        desciption = "House Blend With Steamed Milk";
    }
    
    public double cost(){
        return 0.89 + 0.1;
    }
}
