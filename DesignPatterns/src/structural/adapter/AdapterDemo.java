package structural.adapter;

import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/18/2017.
 */
public class AdapterDemo {

    public static void main(String[] args) {
        EmployeeClient client = new EmployeeClient();

        List<Employee> employees = client.getEmployeeList();

        System.out.println(employees);
    }

}
