package cse.oop2.designpattern.Duck;

import cse.oop2.designpattern.Duck.QuackBehavior_Interface.QuackBehavior;
import cse.oop2.designpattern.Duck.FlyBehavior_Interface.FlyBehavior;


public abstract class Duck {
    protected FlyBehavior flyBehavior; // interface 캡슐화를 통해 , interface 구현체가 자유롭게 초기화 되도록 설정
    protected QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) { // 각각의 구현 Class에서 기본 생성자 안에서 필드 초기화도 가능하지만 현재는 setter도 가능하게 했다.
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
    
    public void swim(){
        System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죠");
    }
    
    public abstract void display(); // 추상 메소드
    
    public void performQuack(){ // interface 캡슐화를 통해, 어떤 interface 구현체가 오느냐에 따라 Method 결과가 달라진다.
        quackBehavior.quack();
    }
    
    public void performFly(){
        flyBehavior.fly();
    }
    
    
    
    
}
