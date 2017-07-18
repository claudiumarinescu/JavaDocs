package creational.prototype;

import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/18/2017.
 */
public class Statement implements Cloneable {

    private String sql;
    private List<String> params;
    private Record record;

    public Statement(String sql, List<String> params, Record record) {
        this.sql = sql;
        this.params = params;
        this.record = record;
    }

    public Statement clone() {
        try {
            return (Statement) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getParameters() {
        return params;
    }

    public Record getRecord() {
        return record;
    }

    public String getSql() {
        return sql;
    }

    public void setParameters(List<String> parameters) {
        this.params = parameters;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
