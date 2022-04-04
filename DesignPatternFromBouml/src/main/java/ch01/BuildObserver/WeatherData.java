
package ch01.BuildObserver;

import java.util.Observable;

/**
 * 자바 내장 클래스 Observer를 extends 한다.
 */
public class WeatherData extends Observable{
    
    private float temperature;
    private float pressure;
    private float humidity;
    
    public WeatherData(){} // 기본 생성자, 더 이상 Observer를 관리하는 ArrayList를 생성하지 않는다. 부모 클래스에서 알아서 관리
    
    /**
     * 
     * <notifyObservers>
     * If this object has changed, as indicated by the hasChanged method, 
     * then notify all of its observers 
     * and then call the clearChanged method to indicate that this object has no longer changed.
     */
    public void measurementsChanged(){
        setChanged(); // 내장 클래스 안에 선언된 protected Method - Deprecated (권장 되지 않음)
        notifyObservers();     
    }
    
    public void setMeasurements(float temperature, float humidity , float pressure){
      this.temperature = temperature;
      this.humidity = humidity;
      this.pressure = pressure;
      measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }
    
    
    
    
}
