package AbstractFactoryPattern;

import AbstractFactoryPattern.Gt자전거.GtBikeFactory;
import AbstractFactoryPattern.삼천리자전거.SamFactory;

public class Test {
    
    public static void main(String[] args) {
        
        BikeFactory factory = new SamFactory();
        
        factory.createBody();
        factory.createWheel();
        
        
        BikeFactory factory1 = new GtBikeFactory();
        
        factory1.createBody();
        factory1.createWheel();
        
        
        
    }
    
}
