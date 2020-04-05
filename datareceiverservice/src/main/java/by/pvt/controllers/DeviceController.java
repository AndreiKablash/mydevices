package by.pvt.controllers;


import by.pvt.pojo.Device;
import by.pvt.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DeviceController {

    private static final Logger log = Logger.getLogger("DeviceController");

    @Autowired
    DeviceService deviceService;

    @GetMapping("/device")
    public List<Device> getDevices(@RequestParam int maxCount){
        if(maxCount<1) throw new IllegalArgumentException();
        return deviceService.getAllDevices();
    }

    @GetMapping("/device/{deviceId}")
    public Device getDevice(@PathVariable("deviceId") int deviceId){

        return deviceService.getDeviceById(deviceId);
    }

    @PostMapping("/device")
    public void createNewDevice(@RequestBody Device newDevice) {
       Device device = deviceService.getAllDevices().stream()
                .filter(x->x.getDeviceName()
                        .equals(newDevice.getDeviceName())).findFirst().orElse(null);
        if(device!=null){ deviceService.createNewDevice(newDevice);}
        log.info("New device added : " + newDevice);
    }

    @PutMapping("/device/{id}")
    public void updateDevice(@PathVariable int id,
                            @RequestParam Device device){
        log.info("Update device ID = "+ id + " " +  device);
    }

    @DeleteMapping("/device/{id}")

    public void deleteDevice(@PathVariable int id){
        deviceService.deleteDeviceById(id);
        log.info("Device "+ id +" deleted");
    }
}
