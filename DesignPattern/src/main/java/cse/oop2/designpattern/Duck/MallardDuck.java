package cse.oop2.designpattern.Duck;

import cse.oop2.designpattern.Duck.Duck;
import cse.oop2.designpattern.Duck.FlyBehavior_Interface.FlyWithWings;
import cse.oop2.designpattern.Duck.QuackBehavior_Interface.Squeak;


public class MallardDuck extends Duck{

    /**
     * 각각의 Duck 구현체 Class는 추상 클래스 Duck이 가지고 있는 필드를
     * 각기 다른 역할을 하는 interface 구현체로 초기화 시켜주며, 사용하는 
     * interface_Method의 결과도 달라진다.
     */
    public MallardDuck(){ 
        flyBehavior = new FlyWithWings();
        quackBehavior = new Squeak();
    }
    
    @Override
    public void display() {
        System.out.println("저는 MallarDuck 입니다.");
    }
    
}
