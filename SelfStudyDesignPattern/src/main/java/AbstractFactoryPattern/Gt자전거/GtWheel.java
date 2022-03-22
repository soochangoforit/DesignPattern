package AbstractFactoryPattern.Gt자전거;

import AbstractFactoryPattern.Wheel;

public class GtWheel implements Wheel{

    @Override
    public void makeWheel() {
        System.out.println("gt 자전거만의 독특한 wheel 제작");
    }
    
}
