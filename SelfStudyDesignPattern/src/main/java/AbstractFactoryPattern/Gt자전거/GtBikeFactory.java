package AbstractFactoryPattern.Gt자전거;

import AbstractFactoryPattern.BikeFactory;
import AbstractFactoryPattern.Body;
import AbstractFactoryPattern.Wheel;

public class GtBikeFactory implements BikeFactory{

    @Override
    public Body createBody() {
        Body body = new GtBody();
        body.makeBody();
        return null;
    }

    @Override
    public Wheel createWheel() {
        Wheel wheel = new GtWheel();
        wheel.makeWheel();
          return null;
    }
    
}
