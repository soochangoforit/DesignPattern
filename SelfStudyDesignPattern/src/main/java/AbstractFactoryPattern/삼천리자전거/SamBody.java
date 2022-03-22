package AbstractFactoryPattern.삼천리자전거;

import AbstractFactoryPattern.Body;

public class SamBody implements Body{

    @Override
    public void makeBody() {
        System.out.println("삼천리 자전거의 독특한 body 제작");
    }
    
    
    
}
