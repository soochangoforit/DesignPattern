package AbstractFactoryPattern.삼천리자전거;

import AbstractFactoryPattern.Wheel;

public class SamWheel implements Wheel{

    @Override
    public void makeWheel() {
        System.out.println("삼천리 자전거의 독특한 wheel 제작");
    }
    
    
}
