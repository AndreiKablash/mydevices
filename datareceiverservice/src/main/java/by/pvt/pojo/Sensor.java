package by.pvt.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Sensor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sensorName;
    private SensorType sensorType;

    @ManyToOne
    @JoinColumn(name="device_id")
    private Device device;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL)
    private List<SensorData> sensorData;

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", sensorName='" + sensorName + '\'' +
                ", sensorType=" + sensorType +
                ", sensorData=" + sensorData +
                '}';
    }
}
