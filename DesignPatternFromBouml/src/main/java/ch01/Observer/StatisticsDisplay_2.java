
package ch01.Observer;

class StatisticsDisplay_2 implements Observer, DisplayElement {
  private float maxTemp = 0.0f;

  private float minTemp = 100.0f;

  private float sumTemp = 0.0f;

  private float avgTemp = 0.0f;

  private float count = 0.0f;

  private WeatherData weatherData;

  public StatisticsDisplay_2(WeatherData weatherData) {
      this.weatherData = weatherData;
      weatherData.registerObserver(this);
  }

  public void update(float temp, float humidity, float pressure) {
      sumTemp += temp;
      count++;
      avgTemp = sumTemp / count;
      if(temp > maxTemp) { maxTemp = temp; }
      if( temp < minTemp) { minTemp = temp; }
      display();
  }

  public void display() {
      System.out.print("\n\n 날씨 통계 --> ");
      System.out.print("최고 온도 " + maxTemp);
      System.out.print("\t 최저 온도 : " + minTemp);
      System.out.print("\t 평균 온도 : " + avgTemp);
  }

 
}
