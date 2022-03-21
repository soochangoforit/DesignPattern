
package cse.oop2.designpattern.Duck.QuackBehavior_Interface;

/**
 *
 * @author tncks
 */
public class Quack implements QuackBehavior{

    @Override
    public void quack() {
           System.out.println("콱!!!");
    }
    
}
