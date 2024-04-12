package simpledashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpledashboard.repository.MysqlDataReader;

@Service
public class SimpleService {
     @Autowired
    MysqlDataReader mysqlDataReader;

    public void getData() {
        mysqlDataReader.getTemperatue();
    }
}
