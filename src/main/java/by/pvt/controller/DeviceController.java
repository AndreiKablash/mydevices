package by.pvt.controller;

import by.pvt.pojo.device.Device;
import by.pvt.pojo.device.Sensor;
import by.pvt.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Controller
@RequestMapping("/devices")
public class DeviceController {

    private static Logger log = Logger.getLogger("DeviceController.class");

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public String showDeviceList(Model model){
        log.info("Calling show device list");
        model.addAttribute("devices", deviceService.findFirstTopNDevices());
        return "deviceList";
    }

    @GetMapping("/device/{id}")
    public String showDevice(@PathVariable Long id, Model model){
        log.info("call show device");
        Device device = deviceService.findDeviceById(id);
        model.addAttribute("device", device);
        List<Sensor> sensors = device.getSensors();
        Set<Sensor> sens = new HashSet<>();
        sens.addAll(sensors);
        model.addAttribute("sensors", sens);
        return "deviceItem";
    }

    @GetMapping("/device/{deviceId}/sensor/{sensorId}")
    public String showSensorData(@PathVariable Long deviceId, @PathVariable Long sensorId, Model model){
        log.info("call sensor data representation");
        Sensor sensor = deviceService.findDeviceById(deviceId)
                .getSensors()
                .stream()
                .filter(x -> x.getId().equals(sensorId))
                .findFirst()
                .orElse(null);
        log.info("Sensor = " + sensor);
        model.addAttribute("sensor",sensor);
        return "sensorData";
    }
}
