package simpledashboard.repository;

import simpledashboard.entity.DataClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MysqlDataReader implements  DataReader{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void getTemperatue() {
        System.out.println("prendo temperature");
       List<DataClass> result = (List<DataClass>) jdbcTemplate.query("select * from switchbot.data", new BeanPropertyRowMapper<DataClass>(DataClass.class));
    }
}
