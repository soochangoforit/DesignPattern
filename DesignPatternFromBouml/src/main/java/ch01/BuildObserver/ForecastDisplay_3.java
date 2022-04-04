package ch01.BuildObserver;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay_3 implements Observer, DisplayElement{
    
    private float currentTemp = 29.92f;
    private float lastTemp;
    
    public ForecastDisplay_3(Observable observable){
        observable.addObserver(this);
    }
    
    public void update(Observable observable, Object arg){
        if(observable instanceof WeatherData){
            WeatherData weatherData = (WeatherData) observable;
            lastTemp = currentTemp;
            currentTemp = weatherData.getTemperature();
            display();
        }
    }
    
    public void display(){
        System.out.println("기상 예상 정보");
        if(currentTemp > lastTemp) System.out.println("많이 따듯해짐");
        else if(currentTemp == lastTemp) System.out.println("똑같음");
        else if(currentTemp < lastTemp) System.out.println("추워졌다.");
        
    }
    
}
