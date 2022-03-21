
package cse.oop2.designpattern.Duck.QuackBehavior_Interface;


public class Squeak implements QuackBehavior{

    @Override
    public void quack() {
           System.out.println("스쾃!!!");
    }
    
}
