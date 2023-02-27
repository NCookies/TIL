package d02_observer_pattern;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        // 이 외에도 Observer와 DisplayElement 인터페이스를 implement한 다양한 디스플레이를 구현할 수 있지만 여기서는 하나만 구현
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(50, 30, 70.5f);
        weatherData.setMeasurements(60, 80, 45.9f);

        weatherData.removeObserver(currentConditionsDisplay);
        weatherData.setMeasurements(60, 80, 45.9f);
    }
}
