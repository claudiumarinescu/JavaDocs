package ro.teamnet.zth.appl;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.Department;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Claudiu.Marinescu on 7/14/2017.
 */
public class DepartmentDaoTest {

    @Test
    public void testFindById() {
        DepartmentDao dao = new DepartmentDao();
        Department department = dao.findById(80L);

        Assert.assertNotNull("Shouldn't be null!", department);
        Assert.assertEquals("Department name different than expected!", "Sales", department.getDepartmentName());
    }

    @Test
    public void testInsert() {
        DepartmentDao dao = new DepartmentDao();
        Department department = new Department();
        department.setDepartmentName("Telekom");
        department.setLocation(1700L);

        Department result = dao.insert(department);

        Assert.assertNotNull("Shouldn't be null!", result);
        Assert.assertEquals("Department name different than expected!", "Telekom", result.getDepartmentName());
    }

    @Test
    public void testFindAll() {
        DepartmentDao dao = new DepartmentDao();
        List<Department> departments = dao.findAll();

        Assert.assertEquals("Returned list has different size than expected!", 29, departments.size());
    }

    @Test
    public void testUpdate() {
        DepartmentDao dao = new DepartmentDao();
        Department department = dao.findById(272L);
        department.setLocation(2400L);

        Department result = dao.update(department);
        Assert.assertNotNull("Shouldn't be null!", result);
        Assert.assertEquals("Department name different than expected!", 2400L, (long)result.getLocation());
    }

    @Test
    public void testDelete() {
        DepartmentDao dao = new DepartmentDao();
        Department department = dao.findById(272L);

        dao.delete(department);
        Department result = dao.findById(272L);
        Assert.assertNull("Department " + department + " shouldn't be in the table!", result);
    }

    @Test
    public void testFindByParams() {
        DepartmentDao dao = new DepartmentDao();
        Map<String, Object> params = new HashMap<>();
        params.put("LOCATION_ID", 1700L);
        params.put("DEPARTMENT_NAME", "IT Support");

        List<Department> result = dao.findByParams(params);

        Assert.assertNotNull("Shouldn't be null!", result);
        Assert.assertEquals("Array size different than expected!", 2, result.size());
    }

}
