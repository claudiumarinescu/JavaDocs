package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Claudiu.Marinescu on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager {
    @Override
    public <T> T findById(Class<T> entityClass, Long id) {
        T instance = null;
        Connection connection = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);
        //List<Field> fields = EntityUtils.getFieldsByAnnotations(entityClass, Id.class);

        Condition condition = new Condition();
        condition.setValue(id);
        condition.setColumnName(getIdColumnName(columns));

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.addCondition(condition);
        queryBuilder.addQueryColumns(columns);
        queryBuilder.setTableName(tableName);
        queryBuilder.setQueryType(QueryType.SELECT);

        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(queryBuilder.createQuery());

            if (resultSet.next()) {
                instance = entityClass.newInstance();
                for (ColumnInfo column : columns) {
                    Field f = instance.getClass().getDeclaredField(column.getColumnName());
                    f.setAccessible(true);
                    f.set(instance, EntityUtils.castFromSqlType(resultSet.getObject(column.getDbColumnName()), column.getColumnType()));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating statement!");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return instance;
    }

    @Override
    public long getNextIdVal(String tableName, String columnIdName) {
        Connection connection = DBManager.getConnection();

        String statement = "SELECT MAX(" + columnIdName +") + 1 FROM " + tableName;

        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(statement);

            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public <T> Object insert(T entity) {
        long id = -1;
        Connection connection = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());

        for (ColumnInfo column : columns) {
            if (column.isId()) {
                id = getNextIdVal(tableName, column.getDbColumnName());
                column.setValue(id);
            } else {
                try {
                    Field field = entity.getClass().getDeclaredField(column.getColumnName());
                    field.setAccessible(true);
                    column.setValue(field.get(entity));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.addQueryColumns(columns);
        queryBuilder.setQueryType(QueryType.INSERT);

        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(queryBuilder.createQuery());
            return findById(entity.getClass(), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        List<T> entities = new ArrayList<>();
        Connection connection = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.addQueryColumns(columns);
        queryBuilder.setQueryType(QueryType.SELECT);

        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(queryBuilder.createQuery());

            while (resultSet.next()) {
                T instance = entityClass.newInstance();
                for (ColumnInfo column : columns) {
                    Field f = instance.getClass().getDeclaredField(column.getColumnName());
                    f.setAccessible(true);
                    f.set(instance, EntityUtils.castFromSqlType(resultSet.getObject(column.getDbColumnName()), column.getColumnType()));
                }
                entities.add(instance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return entities;
    }

    private String getIdColumnName(List<ColumnInfo> columns) {
        for (ColumnInfo column : columns) {
            if (column.isId()) {
                return column.getDbColumnName();
            }
        }
        return "";
    }
}
