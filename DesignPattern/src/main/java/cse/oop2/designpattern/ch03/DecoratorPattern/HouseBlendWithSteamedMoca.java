package cse.oop2.designpattern.ch03.DecoratorPattern;


public class HouseBlendWithSteamedMoca extends Beverage{
    
    public HouseBlendWithSteamedMoca(){
        desciption = "House Blend With Steamed Moca";
    }
    
    public double cost(){
        return 0.89 + 0.2;
    }
}
