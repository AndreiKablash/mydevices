package by.pvt.controller;

import by.pvt.pojo.device.Device;
import by.pvt.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    DeviceService deviceService;

    @GetMapping
    public String search(@RequestParam("search-str") String str, Model model) {
        List<Device> deviceList = deviceService.searchByDeviceName(str);
        model.addAttribute("result", deviceList);
        return "searchResult";
    }

}
