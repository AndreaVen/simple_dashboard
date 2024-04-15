package simpledashboard.repository;

import org.springframework.stereotype.Repository;
import simpledashboard.entity.HourlyAvgTemperatureHumidity;
import simpledashboard.entity.TemperatureClass;

import java.util.List;

@Repository
public interface TemperatureRepository {
    List<TemperatureClass> getTemperatue();


    List<HourlyAvgTemperatureHumidity> getAvgTempHum();
}
