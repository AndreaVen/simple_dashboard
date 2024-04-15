package simpledashboard.repository;

import org.springframework.beans.factory.annotation.Value;
import simpledashboard.entity.DataClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import simpledashboard.entity.HourlyAvgTemperatureHumidity;
import simpledashboard.entity.TemperatureClass;

import java.util.List;

@Repository
public class MysqlTemperatureRepository implements TemperatureRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${query.hourly.average.temp.hum}")
    private String hourylyAvgTempHumQuery;

    @Override
    public List<TemperatureClass> getTemperatue() {
        List<TemperatureClass> result = (List<TemperatureClass>) jdbcTemplate.query("select * from switchbot.sensor_data limit 1000", new BeanPropertyRowMapper<TemperatureClass>(TemperatureClass.class));

        return result;
    }

    @Override
    public List<HourlyAvgTemperatureHumidity> getAvgTempHum() {
        List<HourlyAvgTemperatureHumidity> result =
                (List<HourlyAvgTemperatureHumidity>) jdbcTemplate.query(hourylyAvgTempHumQuery,
                        new BeanPropertyRowMapper<HourlyAvgTemperatureHumidity>(HourlyAvgTemperatureHumidity.class));


        return  result;
    }


}
