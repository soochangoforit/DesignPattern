package cse.oop2.designpattern.ch03.FinalDecoratorPattern;

public abstract class CondimentDecorator extends Beverage{
    
    protected Beverage beverage; // 상속과 연관의 관계가 모두 있다. , beverage에 대해서 알고 있어여 한다. 
    
    public abstract String getDescription();
    
}
