package simpledashboard.entity;

import org.springframework.data.annotation.Id;

public class HourlyAvgTemperatureHumidity {
    @Id
    private String date;
    private int avg_humidity;
    private float avg_temperature;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAvg_humidity() {
        return avg_humidity;
    }

    public void setAvg_humidity(int avg_humidity) {
        this.avg_humidity = avg_humidity;
    }

    public float getAvg_temperature() {
        return avg_temperature;
    }

    public void setAvg_temperature(float avg_temperature) {
        this.avg_temperature = avg_temperature;
    }
}
