
package ch01.Observer;

class ForecastDisplay_3 implements Observer, DisplayElement {
  private float currentTemp = 29.5f;

  private float lastTemp;

  private WeatherData weatherData; // 추후에 subject 변경을 쉽게 하기 위해서

  public ForecastDisplay_3(WeatherData weatherData) {
      this.weatherData = weatherData;
      weatherData.registerObserver(this);
  }

  public void update(float temp, float humidity, float pressure) {
      this.lastTemp = currentTemp;
      this.currentTemp = temp;
      weatherData.setMeasurements(temp, humidity, pressure);
      
  }

  public void display() {
      System.out.print("\n\n 기상 예보 --> ");
      if(currentTemp > lastTemp) { System.out.print("많이 따뜻해짐"); }
      else if(currentTemp == lastTemp) { System.out.println("온도 똑같음"); }
      else if(currentTemp < lastTemp) { System.out.println("어이쿠! 추워!"); }
      
      System.out.println("\n --------------------------------");
  }


}
