
package cse.oop2.designpattern.ch03.FinalDecoratorPattern;

import cse.oop2.designpattern.ch03.AdvDecoratorPattern.*;

public abstract class Beverage {
    
    protected String description = "UnKnown Beverage";
    
    public String getDescription(){
        return description;
    }
    
    public abstract double cost();
    
}
