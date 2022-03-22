package AbstractFactoryPattern.삼천리자전거;

import AbstractFactoryPattern.BikeFactory;
import AbstractFactoryPattern.Body;
import AbstractFactoryPattern.Wheel;

public class SamFactory implements BikeFactory{

    @Override
    public Body createBody() {
        Body body = new SamBody();
        body.makeBody();
        return null;
    }

    @Override
    public Wheel createWheel() {
        Wheel wheel = new SamWheel();
        wheel.makeWheel();
        return null;
    }
    
}
