package by.pvt.controller;

import by.pvt.pojo.device.Device;
import by.pvt.pojo.device.Sensor;
import by.pvt.service.DeviceService;
import by.pvt.validation.AddDeviceSensorValidation;
import by.pvt.validation.AddDeviceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
@RequestMapping("/add-device")
public class AddDeviceController {

    private static Logger logger = Logger.getLogger(AddDeviceController.class.getName());

    @Autowired
    DeviceService deviceService;

    @Autowired
    AddDeviceValidation deviceValidator;

    @Autowired
    AddDeviceSensorValidation sensorValidator;


    @GetMapping
    public ModelAndView showAddDeviceView(Model model){
        ModelAndView view = new ModelAndView();
        view.addObject("device",new Device());
        view.addObject("sensor", new Sensor());
        view.setViewName("addDevice");
        return view;
    }

    @PostMapping
    public String submitAddProductForm(
            @ModelAttribute("device") Device device,
            BindingResult deviceResult,
            @ModelAttribute("sensor") Sensor sensor,
            BindingResult sensorResult, Model model
    ){

        deviceValidator.validate(device, deviceResult);
        sensorValidator.validate(sensor, sensorResult);
        if (deviceResult.hasErrors()||sensorResult.hasErrors()) {
            model.addAttribute("errors", deviceResult.getAllErrors());
            deviceResult.getAllErrors().forEach(objectError -> logger.info(objectError.getDefaultMessage()));

//            model.addAttribute("errors", sensorResult.getAllErrors());
//            deviceResult.getAllErrors().forEach(objectError -> logger.info(objectError.getDefaultMessage()));

            return "addDevice";
        }

        sensor.setDevice(device);
        device.addSensor(sensor);

        logger.info("Sensor "+ sensor.getSensorName());
        logger.info("Device " + device.getDeviceName());

        if(!deviceService.addDevice(device)){
            return "addDeviceError";
        }
        model.addAttribute("deviceName",device.getDeviceName());
        model.addAttribute("deviceType",device.getDeviceType());
        model.addAttribute("sensorName",sensor.getSensorName());
        return "addDeviceOK";
    }
}
