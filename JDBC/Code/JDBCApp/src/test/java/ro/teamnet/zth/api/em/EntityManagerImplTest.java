package ro.teamnet.zth.api.em;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        d.setDepartmentName("Telecommunications");
        d.setLocation(1000L);
        Department result = (Department) manager.insert(d);

        Assert.assertNotNull("Shouldn't be null!", result);
        Assert.assertEquals("Department name different than expected!", "Telecommunications", result.getDepartmentName());
    }

    @Test
    public void testFindAll() {
        EntityManagerImpl manager = new EntityManagerImpl();
        List<Location> locations = manager.findAll(Location.class);

        Assert.assertEquals("Returned list has different size than expected!", 23, locations.size());
    }

    @Test
    public void testUpdate() {
        EntityManagerImpl manager = new EntityManagerImpl();
        Department department = new Department();
        department.setDepartmentName("Telekomm");
        department.setId(272L);
        department.setLocation(1000L);

        Department result = manager.update(department);
        Assert.assertNotNull("Shouldn't be null!", result);
        Assert.assertEquals("Department name different than expected!", "Telekomm", result.getDepartmentName());
    }

    @Test
    public void testDelete() {
        EntityManagerImpl manager = new EntityManagerImpl();
        Department department = new Department();
        department.setDepartmentName("Telekomm");
        department.setId(272L);
        department.setLocation(1000L);

        manager.delete(department);
        Department result = manager.findById(Department.class, 272L);
        Assert.assertNull("Department " + department.getDepartmentName() + " shouldn't be in the table!", result);
    }

    @Test
    public void testFindByParams() {
        EntityManagerImpl manager = new EntityManagerImpl();
        Map<String, Object> params = new HashMap<>();
        params.put("LOCATION_ID", 1700L);
        params.put("DEPARTMENT_NAME", "IT Support");

        List<Department> result = manager.findByParams(Department.class, params);

        Assert.assertNotNull("Shouldn't be null!", result);
        Assert.assertEquals("Array size different than expected!", 2, result.size());
    }

    @Test
    public void testInsertTransaction() {
        EntityManagerImpl manager = new EntityManagerImpl();
        List<Department> departments = new ArrayList<>();

        Department department1 = new Department();
        department1.setDepartmentName("Training");
        department1.setLocation(1700L);

        Department department2 = new Department();
        department2.setDepartmentName("Cleaning");
        department2.setLocation(1700L);

        departments.add(department1);
        departments.add(department2);

        manager.insertTransaction(departments);
        Department result = manager.findById(Department.class, 273L);
        Assert.assertNotNull(result);
        Assert.assertEquals("Department name different than expected!", "Cleaning", result.getDepartmentName());
    }

}
