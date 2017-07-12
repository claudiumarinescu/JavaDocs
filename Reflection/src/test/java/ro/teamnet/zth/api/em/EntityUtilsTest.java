package ro.teamnet.zth.api.em;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.domain.Job;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/12/2017.
 */
public class EntityUtilsTest {

    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);
        Assert.assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testGetTableNameMethod2() {
        String tableName = EntityUtils.getTableName(Employee.class);
        Assert.assertEquals("Table name should be employees!", "employees", tableName);
    }

    @Test
    public void testGetColumnsWithSomethingElse() {
        int result = EntityUtils.getColumns(String.class).size();
        Assert.assertEquals("List should be empty!", 0, result);
    }

    @Test
    public void testGetColumnsWithTable() {
        int result = EntityUtils.getColumns(Job.class).size();
        Assert.assertEquals("List should contain 4 elements!", 4, result);
    }

    @Test
    public void testCastFromSqlTypeToInteger() {
        Object o = EntityUtils.castFromSqlType(BigDecimal.valueOf(3), Integer.class);
        Assert.assertEquals("Object should be of type Integer!", Integer.class, o.getClass());
    }

    @Test
    public void testCastFromSqlTypeToDouble() {
        Object o = EntityUtils.castFromSqlType(BigDecimal.valueOf(3), Double.class);
        Assert.assertEquals("Object should be of type Double!", Double.class, o.getClass());
    }

    @Test
    public void testGetFieldsByAnnotationId() {
        int result = EntityUtils.getFieldsByAnnotations(Department.class, Id.class).size();
        Assert.assertEquals("There should be only 1 field annotated with Id!", 1, result);
    }

    @Test
    public void testGetFieldsByAnnotationColumn() {
        int result = EntityUtils.getFieldsByAnnotations(Department.class, Column.class).size();
        Assert.assertEquals("There should be 2 fields annotated with Column!", 2, result);
    }

    @Test
    public void testGetSqlValue() {
        Integer result = (Integer) EntityUtils.getSqlValue(new Integer(7));
        Assert.assertEquals("It should return Object of type Integer!", (Integer) 7, result);
    }

    @Test
    public void testGetSqlValue2() {
        Object result = EntityUtils.getSqlValue(new Department());
        Assert.assertNotEquals("It should return a table!", null, result.getClass().getAnnotation(Table.class));
    }

}
