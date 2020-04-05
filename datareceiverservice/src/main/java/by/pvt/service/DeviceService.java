package by.pvt.service;

import by.pvt.pojo.Device;
import by.pvt.pojo.Sensor;
import by.pvt.pojo.SensorData;
import by.pvt.repo.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;


    public List<Device> getAllDevices(){

        return (List<Device>)deviceRepository.findAll();
    }

    public Device getDeviceById(int deviceId) {

        return deviceRepository.findById((long) deviceId).orElseThrow();
    }


    public void createNewDevice(Device device) {
        for(Sensor sensor: device.getSensors()) {
            sensor.setDevice(device);
            for (SensorData sensorData : sensor.getSensorData()) {
                sensorData.setSensor(sensor);
            }
        }
        deviceRepository.save(device);
    }

    public void deleteDeviceById(int deviceId){

        deviceRepository.deleteById((long)deviceId);
    }

}
