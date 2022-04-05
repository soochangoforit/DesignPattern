package cse.oop2.designpattern.ch03.ioDecoratorPattern;

import java.io.IOException;
import java.io.InputStream;

public class InputTest2 {
    
    public void method01(){
        InputStream resource = getClass().getClassLoader().getResourceAsStream("test.txt");
        try(InputStream is = new LowerCaseInputStream(resource)){
            while(is.available() > 0){
                System.out.print((char) is.read());
            }
        }catch (IOException e){
            System.out.println("오류 발생" + e.getMessage());
        }
    }
    
}
