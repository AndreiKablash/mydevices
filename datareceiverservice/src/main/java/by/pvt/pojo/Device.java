package by.pvt.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DeviceLocation> deviceLocations;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<Sensor> sensors;



}
