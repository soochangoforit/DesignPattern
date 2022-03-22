package AbstractFactoryPattern.Gt자전거;

import AbstractFactoryPattern.Body;

public class GtBody implements Body{

    @Override
    public void makeBody() {
        System.out.println("gt 자전거 만의 독특한 body 제작");
    }
    
}
