package ro.teamnet.zth.appl;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.dao.EmployeeDao;
import ro.teamnet.zth.appl.domain.Employee;

import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/14/2017.
 */
public class EmployeeDaoTest {

    @Test
    public void testSearchByDepartment() {
        EmployeeDao dao = new EmployeeDao();
        String departmentSubString = "iOn";

        List<Employee> result = dao.searchByDepartment(departmentSubString);
        Assert.assertEquals("Array size is different than expected!", 2, result.size());
    }

}
