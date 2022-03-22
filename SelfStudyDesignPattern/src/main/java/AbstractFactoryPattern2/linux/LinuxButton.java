package AbstractFactoryPattern2.linux;

import AbstractFactoryPattern2.abst.Button;

public class LinuxButton implements Button{
    
    public void click(){
        System.out.println("리눅스 버튼");
    }
}
