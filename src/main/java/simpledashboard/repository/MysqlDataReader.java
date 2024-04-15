package simpledashboard.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MysqlDataReader implements  DataReader{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void getTemperatue() {
        System.out.println("prendo temperature");
        int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM switchbot.sensor_data", Integer.class);
        System.out.println(result);
    }
}
