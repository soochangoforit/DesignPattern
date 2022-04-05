package cse.oop2.designpattern.ch03.DecoratorPattern;


public abstract class Beverage {
    
    protected String desciption;

    public String getDesciption() {
        return desciption;
    }
    
    // 상속하는 하위 클래스들이 Override하기 위해 Abstract 결정
    public abstract double cost();
    
    
    
}
