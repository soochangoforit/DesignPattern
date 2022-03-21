package cse.oop2.designpattern.Duck;

import cse.oop2.designpattern.Duck.FlyBehavior_Interface.FlyWithWings;
import cse.oop2.designpattern.Duck.QuackBehavior_Interface.Squeak;


public class RubberDuck extends Duck{

    public RubberDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Squeak();
    }
    
    @Override
    public void display() {
        System.out.println("저는 RubberDuck 입니다.");
    }
    
}
