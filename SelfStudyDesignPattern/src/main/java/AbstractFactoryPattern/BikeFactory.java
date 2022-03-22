package AbstractFactoryPattern;

public interface BikeFactory {
    
    public Body createBody();
    public Wheel createWheel();
   
}
