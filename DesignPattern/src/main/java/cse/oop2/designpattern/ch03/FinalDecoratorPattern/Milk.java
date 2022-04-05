
package cse.oop2.designpattern.ch03.FinalDecoratorPattern;


public class Milk extends CondimentDecorator{
    
    public Milk(Beverage beverage){ // 서브 클래스에서 생성자를 통해, CondimentDecorator 의 beverage 부분을 초기화
        this.beverage = beverage;
    }
    
    public String getDescription(){
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
       return  0.10 + beverage.cost();
    }
    
}
