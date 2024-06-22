package simpledashboard.entity;

import java.time.LocalDateTime;

public class HourlyAvgTemperatureHumidity {

    private LocalDateTime date;

    private float avg_humidity;
    private float avg_temperature;

    private String id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public float getAvg_humidity() {
        return avg_humidity;
    }

    public void setAvg_humidity(float avg_humidity) {
        this.avg_humidity = avg_humidity;
    }

    public float getAvg_temperature() {
        return avg_temperature;
    }

    public void setAvg_temperature(float avg_temperature) {
        this.avg_temperature = avg_temperature;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
