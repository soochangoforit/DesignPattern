
package cse.oop2.designpattern.Duck.QuackBehavior_Interface;

/**
 *
 * @author tncks
 */
public class MuteQuack implements QuackBehavior{

    @Override
    public void quack() {
           System.out.println("울음소리를 내지 않습니다.");
    }
    
}
