package by.pvt.repo;

import by.pvt.pojo.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DeviceRepository extends CrudRepository<Device,Long> {

}
