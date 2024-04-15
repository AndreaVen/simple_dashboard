package simpledashboard.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import simpledashboard.entity.HourlyAvgTemperatureHumidity;
import simpledashboard.entity.TemperatureClass;
import simpledashboard.service.SimpleService;

@Controller
public class GoogleChartsController {
    @Autowired
    SimpleService simpleService;

    @GetMapping("/")
    public String getPieChart(Model model) throws InterruptedException {
        Map<String, Integer> graphData = new TreeMap<>();
        graphData.put("2016", 147);
        graphData.put("2017", 1256);
        graphData.put("2018", 3856);
        graphData.put("2019", 19807);
        model.addAttribute("chartData", graphData);
        return "google-charts";
    }

    @GetMapping("/getData")
    public String getData(Model model) {
        List<HourlyAvgTemperatureHumidity> hourlyAvgTemperatureHumidities=simpleService.getHourlyAvgTempHum();


        Map<String, Float> graphData = new TreeMap<>();
        int i=0;
         while (i<hourlyAvgTemperatureHumidities.size()-1){
             i=i+1;
             String date=hourlyAvgTemperatureHumidities.get(i).getDate();
             Float temp=hourlyAvgTemperatureHumidities.get(i).getAvg_temperature();
             graphData.put(date,temp );

         }


        model.addAttribute("chartData", graphData);

        return "temperature-chart";
        
    }


}