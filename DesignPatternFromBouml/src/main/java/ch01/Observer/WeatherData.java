
package ch01.Observer;

import java.util.ArrayList;

class WeatherData implements Subject {
    
  private float temp;

  private float humidity;

  private float pressure;

  private ArrayList<Observer> observers;

  public WeatherData() {
      observers = new ArrayList<>();
  }

  public void registerObserver(Observer o) {
      observers.add(o);
  }

  public void removeObserver(Observer o) {
      int i = observers.indexOf(o);
      if(i>= 0) { observers.remove(i); }
  }

  public void notifyObservers() {
      observers.stream().map(e -> (Observer) e).forEach( a -> a.update(temp, humidity, pressure));
  }

  public void measurementsChanged() {
      notifyObservers();
  }

  public void setMeasurements(float temp, float humidity, float pressure) {
      this.temp = temp;
      this.humidity = humidity;
      this.pressure = pressure;
      measurementsChanged();
  }

  public float getTemp() {
      return this.temp;
  }

  public float getHumidity() {
      return this.humidity;
  }

  public float getPressure() {
      return this.pressure;
  }

}
