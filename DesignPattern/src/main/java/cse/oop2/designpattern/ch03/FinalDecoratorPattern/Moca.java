
package cse.oop2.designpattern.ch03.FinalDecoratorPattern;


public class Moca extends CondimentDecorator{
    
    public Moca(Beverage beverage){ // 서브 클래스에서 생성자를 통해, CondimentDecorator 의 beverage 부분을 초기화
        this.beverage = beverage;
    }
    
    public String getDescription(){
        return beverage.getDescription() + ", Moca";
    }

    @Override
    public double cost() {
       return  0.20 + beverage.cost();
    }
    
}
