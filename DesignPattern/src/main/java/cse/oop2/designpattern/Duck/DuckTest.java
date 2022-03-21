package cse.oop2.designpattern.Duck;

import cse.oop2.designpattern.Duck.FlyBehavior_Interface.FlyWithWings;
import cse.oop2.designpattern.Duck.QuackBehavior_Interface.Quack;

public class DuckTest {

    public static void main(String[] args) {
        
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();
        
        System.out.println("---------------------------");
        
        Duck redHeadDuck = new RedheadDuck();
        redHeadDuck.display();
        redHeadDuck.performFly();
        redHeadDuck.performQuack();
        
        System.out.println("---------------------------");

        
        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.performQuack();
        
        System.out.println("---------------------------");
        
        Duck decoyDuck = new DecoyDuck();
        decoyDuck.display();
        decoyDuck.performFly();
        decoyDuck.performQuack();
        
        System.out.println("--------decoyDuck interface 역할 설정 변경 from setter ------------");
        decoyDuck.setFlyBehavior(new FlyWithWings());
        decoyDuck.setQuackBehavior(new Quack());
        
        decoyDuck.performFly();
        decoyDuck.performQuack();
        
        
    }
    
}
