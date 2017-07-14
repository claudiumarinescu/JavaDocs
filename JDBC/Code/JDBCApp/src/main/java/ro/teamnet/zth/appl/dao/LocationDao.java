package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Location;

import java.util.List;
import java.util.Map;

/**
 * Created by Claudiu.Marinescu on 7/14/2017.
 */
public class LocationDao {

    private EntityManager manager;

    public LocationDao() {
        this.manager = new EntityManagerImpl();
    }

    public Location findById(Long id) {
        return manager.findById(Location.class, id);
    }

    public long getNextIdVal(String tableName, String columnIdName) {
        return manager.getNextIdVal(tableName, columnIdName);
    }

    public Location insert(Location location) {
        return (Location) manager.insert(location);
    }

    public List<Location> findAll() {
        return manager.findAll(Location.class);
    }

    public Location update(Location location) {
        return manager.update(location);
    }

    public void delete(Location location) {
        manager.delete(location);
    }

    public List<Location> findByParams(Map<String, Object> params) {
        return manager.findByParams(Location.class, params);
    }

}
