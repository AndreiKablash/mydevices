package by.pvt.pojo.device;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Device implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deviceName;
    private DeviceType deviceType;
    private String deviceIPAddress;

    @OneToMany(fetch = FetchType.EAGER, cascade =CascadeType.ALL,
            orphanRemoval = true)
    private Set<DeviceLocation> deviceLocations;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "device" ,cascade =CascadeType.ALL,
            orphanRemoval = true)
    private List<Sensor> sensors = new ArrayList<>();

    public String getDeviceName() {
        return deviceName;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }


    public void addSensor(Sensor sensor){
        sensors.add(sensor);
    }

}
