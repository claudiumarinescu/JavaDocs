package ro.teamnet.zth.appl;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.dao.LocationDao;
import ro.teamnet.zth.appl.domain.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Claudiu.Marinescu on 7/14/2017.
 */
public class LocationDaoTest {

    @Test
    public void testFindById() {
        LocationDao dao = new LocationDao();
        Location l = dao.findById(2400L);

        Assert.assertNotNull("Shouldn't be null!", l);
        Assert.assertEquals("Location name different than expected!", "8204 Arthur St", l.getStreetAddress());
    }

    @Test
    public void testInsert() {
        LocationDao dao = new LocationDao();
        Location location = new Location();
        location.setCity("Bucharest");
        location.setPostalCode("12345");
        location.setStateProvince("Bucharest");
        location.setStreetAddress("22 Bld Tudor Vladimirescu");
        location.setId(-1L);

        Location result = dao.insert(location);

        Assert.assertNotNull("Shouldn't be null!", result);
        Assert.assertEquals("Location name different than expected!", "22 Bld Tudor Vladimirescu", result.getStreetAddress());
    }

    @Test
    public void testFindAll() {
        LocationDao dao = new LocationDao();
        List<Location> locations = dao.findAll();

        Assert.assertEquals("Returned list has different size than expected!", 24, locations.size());
    }

    @Test
    public void testUpdate() {
        LocationDao dao = new LocationDao();
        Location location = dao.findById(3201L);
        location.setStreetAddress("236 Calea Mosilor");
        location.setPostalCode("33444");

        Location result = dao.update(location);
        Assert.assertNotNull("Shouldn't be null!", result);
        Assert.assertEquals("Location name different than expected!", "236 Calea Mosilor", result.getStreetAddress());
    }

    @Test
    public void testDelete() {
        LocationDao dao = new LocationDao();
        Location location = dao.findById(3201L);

        dao.delete(location);
        Location result = dao.findById(3201L);
        Assert.assertNull("Location " + location + " shouldn't be in the table!", result);
    }

    @Test
    public void testFindByParams() {
        LocationDao dao = new LocationDao();
        Map<String, Object> params = new HashMap<>();
        params.put("CITY", "Tokyo");
        params.put("STATE_PROVINCE", "Tokyo Prefecture");

        List<Location> result = dao.findByParams(params);

        Assert.assertNotNull("Shouldn't be null!", result);
        Assert.assertEquals("Array size different than expected!", 1, result.size());
    }

}
