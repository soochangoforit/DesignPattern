
package cse.oop2.designpattern.Duck.FlyBehavior_Interface;

import cse.oop2.designpattern.Duck.FlyBehavior_Interface.FlyBehavior;


public class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("날 수 있어!!");
    }
    
}
