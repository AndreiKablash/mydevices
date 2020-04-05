package by.pvt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class SensorDataChartsController {


    @GetMapping
    public String showSensorDataChart(){
        return "chart";
    }



}
