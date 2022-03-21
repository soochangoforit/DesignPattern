
package cse.oop2.designpattern.Duck;

import cse.oop2.designpattern.Duck.FlyBehavior_Interface.FlyWithWings;
import cse.oop2.designpattern.Duck.QuackBehavior_Interface.Quack;


public class RedheadDuck extends Duck{

    public RedheadDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    
    @Override
    public void display() {
            System.out.println("저는 RedheadDuck 입니다.");
    }
    
    
    
}
