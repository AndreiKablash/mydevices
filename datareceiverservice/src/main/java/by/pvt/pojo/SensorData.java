package by.pvt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
    private Date date;
    private String value;

    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + id +
                ", date=" + date +
                ", value='" + value + '\'' +
                '}';
    }
}
