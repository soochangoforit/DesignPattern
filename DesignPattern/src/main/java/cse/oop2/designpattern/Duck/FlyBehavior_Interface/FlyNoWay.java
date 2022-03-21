
package cse.oop2.designpattern.Duck.FlyBehavior_Interface;

import cse.oop2.designpattern.Duck.FlyBehavior_Interface.FlyBehavior;


public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("날지 못해요!!");
    }
    
}
