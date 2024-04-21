package simpledashboard.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import simpledashboard.entity.HourlyAvgTemperatureHumidity;
import simpledashboard.entity.TemperatureClass;
import simpledashboard.service.SimpleService;
import simpledashboard.utils.DateUtils;

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
        List<String> listOfDevices=hourlyAvgTemperatureHumidities.stream().map(HourlyAvgTemperatureHumidity::getName).distinct().collect(Collectors.toList());
        int nDevices=1;
        for (String currentDevice:listOfDevices){
            Map<Date, Float> graphData=new TreeMap<>();


            List<HourlyAvgTemperatureHumidity> currentSeries=hourlyAvgTemperatureHumidities.stream()
                 .filter(o-> StringUtils.wildCompareIgnoreCase(currentDevice,o.getName())).collect(Collectors.toList());

            for (HourlyAvgTemperatureHumidity value:currentSeries){
                Date date= DateUtils.StringToDate(value.getDate());
                float temp=value.getAvg_temperature();
                graphData.put(date,temp);

            }
            model.addAttribute("device"+nDevices,currentDevice);
            model.addAttribute("chartData_s"+nDevices, graphData);
            nDevices++;



        }






        return "temperature-chart";
        
    }


}