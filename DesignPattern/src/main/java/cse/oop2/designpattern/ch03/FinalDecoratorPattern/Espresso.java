package cse.oop2.designpattern.ch03.FinalDecoratorPattern;

import cse.oop2.designpattern.ch03.DecoratorPattern.*;


public class Espresso extends Beverage{
    
    public Espresso(){
        description = "Espresso";
    }
    
    public double cost(){
        return 1.99;
    }
    
    
    
}
