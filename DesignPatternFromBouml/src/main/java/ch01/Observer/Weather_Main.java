
package ch01.Observer;


public class Weather_Main {
    public static void main(String[] args) {
        
        WeatherData weatherData = new WeatherData();
        
        CurrentConditions_1 currentDisplay = new CurrentConditions_1(weatherData);
        StatisticsDisplay_2 statisticsDisplay = new StatisticsDisplay_2(weatherData);
        ForecastDisplay_3 forecastDisplay_3 = new ForecastDisplay_3(weatherData);
        
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(80, 65, 30.4f);
        
        
    }
    
}
