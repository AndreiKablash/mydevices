package by.pvt.pojo.device;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class DeviceLocation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double longitude;
    private double latitude;

    @Override
    public String toString() {
        return "DeviceLocation{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
