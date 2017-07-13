package ro.teamnet.zth.api.em;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/13/2017.
 */
public class EntityManagerImplTest {

    @Test
    public void testFindById() {
        EntityManagerImpl manager = new EntityManagerImpl();
        Department d = manager.findById(Department.class, 70l);

        Assert.assertNotNull("Shouldn't be null!", d);
        Assert.assertEquals("Department name different than expected!", "Public Relations", d.getDepartmentName());
    }

    @Test
    public void testGetNextIdVal() {
        EntityManagerImpl manager = new EntityManagerImpl();
        long id = manager.getNextIdVal("locations", "location_id");

        Assert.assertNotEquals("Shouldn't be -1!", -1, id);
        Assert.assertEquals("Id different than expected!", 3201L, id);
    }

    @Test
    public void testInsert() {
        EntityManagerImpl manager = new EntityManagerImpl();
        Department d = new Department();
        d.setDepartmentName("Telecommunication");
        d.setLocation(1000L);
        Department result = (Department) manager.insert(d);

        Assert.assertNotNull("Shouldn't be null!", result);
        Assert.assertEquals("Department name different than expected!", "Telecommunication", result.getDepartmentName());


    }

    @Test
    public void testFindAll() {
        EntityManagerImpl manager = new EntityManagerImpl();
        List<Location> locations = manager.findAll(Location.class);

        Assert.assertEquals("Returned list has different size than expected!", 23, locations.size());
    }

}
