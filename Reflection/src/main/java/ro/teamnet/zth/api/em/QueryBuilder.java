package ro.teamnet.zth.api.em;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/12/2017.
 */
public class QueryBuilder {

    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;

    public String getValueForQuery(Object value) {
        if (value.getClass().getName().equals("java.lang.String")) {
            return (String)value;
        }
        if (value.getClass().getName().equals("java.util.Date")) {
            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            return "TO_DATE('" + dateFormat.format((Date)value) + "','mm-dd-YYYY'";
        }
        return value.toString();
    }

    public QueryBuilder addCondition(Condition condition) {
        conditions.add(condition);
        return this;
    }

    public QueryBuilder setTableName(Object tableName) {
        this.tableName = tableName;
        return this;
    }

    public QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns) {
        this.queryColumns.addAll(queryColumns);
        return this;
    }

    public QueryBuilder setQueryType(QueryType queryType) {
        this.queryType = queryType;
        return this;
    }

}
