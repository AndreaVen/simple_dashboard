package simpledashboard.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class TemperatureClass {

    private float temperature;
    private int humidity;

    private String id;
    @Id
    private String timestamp_id;
    private String name;
    private Date date;

    private Date timestamp;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp_id() {
        return timestamp_id;
    }

    public void setTimestamp_id(String timestamp_id) {
        this.timestamp_id = timestamp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
