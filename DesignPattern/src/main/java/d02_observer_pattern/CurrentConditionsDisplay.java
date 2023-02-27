package d02_observer_pattern;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    // 생성자에서 주제 객체가 전달되며, 그 객체를 써서 디스플레이를 옵저버로 등록함
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions : " + temperature + "F degrees and "
                + humidity + "% humidity");
    }
}
