package AbstractFactoryPattern2.linux;

import AbstractFactoryPattern2.abst.Button;
import AbstractFactoryPattern2.abst.GuiFac;
import AbstractFactoryPattern2.abst.TextArea;

public class LinuxGuiFac implements GuiFac{
    
    public Button createButton(){
        
        return new LinuxButton();
    }
    
    public TextArea createTextArea(){
        
        return new LinuxTextArea();
    }
    
}
