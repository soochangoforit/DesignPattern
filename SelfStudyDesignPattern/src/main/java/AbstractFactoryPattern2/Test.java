package AbstractFactoryPattern2;

import AbstractFactoryPattern2.abst.Button;
import AbstractFactoryPattern2.abst.GuiFac;
import AbstractFactoryPattern2.abst.TextArea;
import AbstractFactoryPattern2.linux.LinuxGuiFac;


public class Test {
    public static void main(String[] args) {
        
        GuiFac fac = new LinuxGuiFac();
        Button button = fac.createButton();
        TextArea area = fac.createTextArea();
        
        button.click();
        System.out.println(area.getText());
        
    }
    
}
