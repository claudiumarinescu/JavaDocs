package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            stmt.executeQuery(queryBuilder.createQuery());
            return findById(entity.getClass(), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> void insertTransaction(List<T> entities) {
        if (entities.size() == 0)   return;
        try (Connection connection = DBManager.getConnection()) {
            connection.setAutoCommit(false);

            for (T entity : entities) {

                String tableName = EntityUtils.getTableName(entity.getClass());
                List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());
                long id;

                for (ColumnInfo column : columns) {
                    if (column.isId()) {
                        id = getNextIdVal(tableName, column.getDbColumnName()) + entities.indexOf(entity);
                        column.setValue(id);
                    } else {
                        Field field = entity.getClass().getDeclaredField(column.getColumnName());
                        field.setAccessible(true);
                        column.setValue(field.get(entity));
                    }
                }

                QueryBuilder queryBuilder = new QueryBuilder();
                queryBuilder.setTableName(tableName);
                queryBuilder.addQueryColumns(columns);
                queryBuilder.setQueryType(QueryType.INSERT);

                try (Statement stmt = connection.createStatement()) {
                    stmt.executeQuery(queryBuilder.createQuery());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        Connection connection = DBManager.getConnection();

        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.addQueryColumns(columns);
        queryBuilder.setQueryType(QueryType.SELECT);

        return getResultList(entityClass, connection, queryBuilder);
    }

    @Override
    public <T> T update(T entity) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());
        Long id = 0L;
        String dbColumnName = "";

        for (ColumnInfo column : columns) {
            try {
                Field field = entity.getClass().getDeclaredField(column.getColumnName());
                field.setAccessible(true);
                column.setValue(field.get(entity));
                if (column.isId()) {
                    id = (Long) column.getValue();
                    dbColumnName = column.getDbColumnName();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Condition condition = new Condition();
        condition.setValue(id);
        condition.setColumnName(dbColumnName);

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.addQueryColumns(columns);
        queryBuilder.addCondition(condition);
        queryBuilder.setQueryType(QueryType.UPDATE);

        try (Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(queryBuilder.createQuery());
            if (resultSet.next()) {
                return entity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Object entity) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());
        Long id = -1L;
        String dbColumnName = "";
        Field field;

        for (ColumnInfo column : columns) {
            try {
                field = entity.getClass().getDeclaredField(column.getColumnName());
                field.setAccessible(true);
                column.setValue(field.get(entity));
                if (column.isId()) {
                    id = (Long) column.getValue();
                    dbColumnName = column.getDbColumnName();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Condition condition = new Condition();
        condition.setValue(id);
        condition.setColumnName(dbColumnName);

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.addQueryColumns(columns);
        queryBuilder.addCondition(condition);
        queryBuilder.setQueryType(QueryType.DELETE);

        try (Statement stmt = connection.createStatement()) {
            stmt.executeQuery(queryBuilder.createQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) {
        Connection connection = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);

        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setTableName(tableName);
        queryBuilder.addQueryColumns(columns);
        queryBuilder.setQueryType(QueryType.SELECT);

        Set<Map.Entry<String, Object>> entries = params.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            Condition condition = new Condition();
            condition.setValue(entry.getValue());
            condition.setColumnName(entry.getKey());
            queryBuilder.addCondition(condition);
        }

        return getResultList(entityClass, connection, queryBuilder);
    }

    private <T> List<T> getResultList(Class<T> entityClass, Connection c, QueryBuilder q) {
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);
        List<T> result = new ArrayList<>();

        try (Statement stmt = c.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(q.createQuery());
            while (resultSet.next()) {
                T instance = entityClass.newInstance();
                for (ColumnInfo column : columns) {
                    Field field = instance.getClass().getDeclaredField(column.getColumnName());
                    field.setAccessible(true);
                    field.set(instance, EntityUtils.castFromSqlType(resultSet.getObject(column.getDbColumnName()), column.getColumnType()));
                }
                result.add(instance);
            }
        } catch (SQLException | NoSuchFieldException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
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
