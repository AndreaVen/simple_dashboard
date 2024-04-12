package simpledashboard.controller;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import simpledashboard.service.SimpleService;

@Controller
public class GoogleChartsController {
    @Autowired
    SimpleService simpleService;

    @GetMapping("/")
    public String getPieChart(Model model) {
        Map<String, Integer> graphData = new TreeMap<>();
        graphData.put("2016", 147);
        graphData.put("2017", 1256);
        graphData.put("2018", 3856);
        graphData.put("2019", 19807);
        model.addAttribute("chartData", graphData);
        return "google-charts";
    }

    @GetMapping("/getData")
    public void getData() {
        simpleService.getData();
    }


}