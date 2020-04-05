package by.pvt.repository;

import by.pvt.pojo.device.Device;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeviceRepository {

    @Autowired
    SessionFactory sessionFactory;

    public List<Device> findAll(int count){
        return sessionFactory.getCurrentSession()
                .createQuery("from Device", Device.class)
                .setMaxResults(count)
                .list();
    }

    public Device findById(Long id){
        return sessionFactory.getCurrentSession().get(Device.class, id);
    }

    public List<Device> findByDeviceName(String str, int count){
        return sessionFactory.getCurrentSession()
                .createQuery("from Device d where d.deviceName like:searchStr", Device.class)
                .setParameter("searchStr","%"+str+"%")
                .setMaxResults(count)
                .list();
    }

    public boolean addDevice(Device device) {
        sessionFactory.getCurrentSession()
                .persist(device);
        return true;
    }
}
