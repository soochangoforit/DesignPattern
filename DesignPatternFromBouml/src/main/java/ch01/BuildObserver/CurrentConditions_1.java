package ch01.BuildObserver;


import java.util.Observable;
import java.util.Observer;

public class CurrentConditions_1 implements Observer, DisplayElement{
    
    Observable observable; // 있어도 되고, 없어도 된다.
    WeatherData weatherData; // weatherData의 presure 사용하기 위해...
    private float temperature;
    private float humidity;
    
    public CurrentConditions_1(Observable observable){
        
        this.observable = observable; // 없어도 괜찮다.
        this.observable.addObserver(this); // 상위 클래스인 내장 Observable에서 Observer를 관리, 해당 observer는 자신의 인스턴스를 주입하기 위해 this 사용
    }
    
    
    public void update(Observable obs, Object arg){
        if(obs instanceof WeatherData){ // 내장 클래스를 사용하기 때문에, weatherData 말고도 넘어올 수 있는 가능성이 있다. 해당 instance인지 검증후, Down casting 진행
            this.weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
        }
    }
    
    public void display(){
        System.out.println("현재날씨 ,,,온도 "+ temperature + " 습도 : "+ humidity +  " 기압 : " + weatherData.getPressure());
    }

}
