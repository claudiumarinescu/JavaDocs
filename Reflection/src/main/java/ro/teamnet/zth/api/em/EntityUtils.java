package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/12/2017.
 */
public class EntityUtils {

    private EntityUtils() throws UnsupportedOperationException {}

    public static String getTableName(Class entity) {
        if (entity.getAnnotation(Table.class) != null) {
            return ((Table)entity.getAnnotation(Table.class)).name();
        }
        return entity.getName();
    }

    public static List<ColumnInfo> getColumns(Class entity) {
        List<ColumnInfo> cols = new ArrayList<>();

        if (entity.getAnnotation(Table.class) != null) {
            Field[] fields = entity.getDeclaredFields();
            for (Field field : fields) {
                if (field.getAnnotation(Id.class) != null) {
                    ColumnInfo col = new ColumnInfo();
                    col.setIsId(true);
                    col.setDbColumnName(field.getAnnotation(Id.class).name());
                    col.setColumnType(field.getType());
                    col.setColumnName(field.getName());
                    cols.add(col);
                } else if (field.getAnnotation(Column.class) != null) {
                    ColumnInfo col = new ColumnInfo();
                    col.setIsId(false);
                    col.setDbColumnName(field.getAnnotation(Column.class).name());
                    col.setColumnType(field.getType());
                    col.setColumnName(field.getName());
                    cols.add(col);
                }
            }
        }
        return cols;
    }

    public static Object castFromSqlType(Object value, Class wantedType) {
        if (value instanceof BigDecimal) {
            if (wantedType.getName().equals("java.lang.Integer")) {
                return ((BigDecimal) value).intValue();
            }
            if (wantedType.getName().equals("java.lang.Long")) {
                return ((BigDecimal) value).longValue();
            }
            if (wantedType.getName().equals("java.lang.Float")) {
                return ((BigDecimal) value).floatValue();
            }
            return ((BigDecimal) value).doubleValue();
        }
        return value;
    }

    public static List<Field> getFieldsByAnnotations(Class clazz, Class annotation) {
        List<Field> list = new ArrayList<Field>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(annotation) != null) {
                list.add(field);
            }
        }
        return list;
    }

    public static Object getSqlValue(Object object) {
        if (object.getClass().getAnnotation(Table.class) != null) {
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getAnnotation(Id.class) != null) {
                    field.setAccessible(true);
                    break;
                }
            }
        }
        return object;
    }














}
