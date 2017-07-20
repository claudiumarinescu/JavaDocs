package ro.teamnet.zth.repos;


import org.springframework.data.repository.CrudRepository;
import ro.teamnet.zth.appl.Employee;

/**
 * Created by Claudiu.Marinescu on 7/19/2017.
 */

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
