
package ch01.Observer;

class CurrentConditions_1 implements Observer, DisplayElement {
  private float temp;

  private float humidity;

  private float pressure;

  private WeatherData weatherData;

  public CurrentConditions_1(WeatherData weatherData) {
      this.weatherData = weatherData;
      weatherData.registerObserver(this);
  }

  public void update(float temp, float humidity, float pressure) {
      this.temp = temp;
      this.humidity = humidity;
      this.pressure = pressure;
      display();
  }

  public void display() {
      
      System.out.print("\n 현재 날씨 --> ");
      System.out.print(" 현재 온도 : " + temp);
      System.out.print("\t 습도 : " + humidity);
      System.out.print("\t 기압 : " + pressure);
  }

}