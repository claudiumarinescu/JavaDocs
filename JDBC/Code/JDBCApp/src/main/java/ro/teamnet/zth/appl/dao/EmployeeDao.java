package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.api.em.ColumnInfo;
import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.api.em.EntityUtils;
import ro.teamnet.zth.appl.domain.Employee;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Claudiu.Marinescu on 7/14/2017.
 */
public class EmployeeDao {

    private EntityManager manager;

    public EmployeeDao() {
        this.manager = new EntityManagerImpl();
    }

    public Employee findById(Long id) {
        return manager.findById(Employee.class, id);
    }

    public long getNextIdVal(String tableName, String columnIdName) {
        return manager.getNextIdVal(tableName, columnIdName);
    }

    public Employee insert(Employee employee) {
        return (Employee) manager.insert(employee);
    }

    public List<Employee> findAll() {
        return manager.findAll(Employee.class);
    }

    public Employee update(Employee employee) {
        return manager.update(employee);
    }

    public void delete(Employee employee) {
        manager.delete(employee);
    }

    public List<Employee> findByParams(Map<String, Object> params) {
        return manager.findByParams(Employee.class, params);
    }

    public List<Employee> searchByDepartment(String department) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(Employee.class);
        List<ColumnInfo> columns = EntityUtils.getColumns(Employee.class);
        List<Employee> result = new ArrayList<>();
        String sql = "SELECT E.*, D.DEPARTMENT_NAME FROM EMPLOYEES E JOIN DEPARTMENTS D ON E.DEPARTMENT_ID=D.DEPARTMENT_ID " +
                "WHERE UPPER(D.DEPARTMENT_NAME) LIKE '%'||UPPER('" + department + "')||'%'";

        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee();
                for (ColumnInfo column : columns) {
                    Field field = employee.getClass().getDeclaredField(column.getColumnName());
                    field.setAccessible(true);
                    field.set(employee, EntityUtils.castFromSqlType(resultSet.getObject(column.getDbColumnName()), column.getColumnType()));
                }
                result.add(employee);
            }
        } catch (SQLException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }


}
