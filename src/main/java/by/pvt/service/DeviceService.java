package by.pvt.service;


import by.pvt.pojo.device.Device;
import by.pvt.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeviceService {

    private static final int SEARCH_COUNT =10;

    @Autowired
    DeviceRepository deviceRepository;

    @Transactional
    public List<Device> findFirstTopNDevices(){
        return deviceRepository.findAll(SEARCH_COUNT);
    }

    @Transactional
    public Device findDeviceById(Long id){
        return deviceRepository.findById(id);
    }

    @Transactional
    public List<Device> searchByDeviceName(String str){
        return deviceRepository.findByDeviceName(str, SEARCH_COUNT);
    }


    @Transactional
    public boolean addDevice(Device device) {
        if (device.getDeviceName() == null || device.getDeviceType()== null ||
                device.getSensors().isEmpty()) {
            return false;
        }
        return deviceRepository.addDevice(device);
    }
}
