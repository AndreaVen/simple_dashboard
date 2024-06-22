package simpledashboard.service;

import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpledashboard.entity.HourlyAvgTemperatureHumidity;
import simpledashboard.entity.TemperatureClass;
import simpledashboard.repository.MysqlTemperatureRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimpleService {
     @Autowired
     MysqlTemperatureRepository mysqlDataReader;

    public List<TemperatureClass> getData() {
        List<TemperatureClass> result = mysqlDataReader.getTemperatue();
        return result;
    }

    public List<HourlyAvgTemperatureHumidity> getHourlyAvgTempHum(){
        List<HourlyAvgTemperatureHumidity> result = mysqlDataReader.getAvgTempHum().stream().collect(Collectors.toList());
        return  result;


    }



}
